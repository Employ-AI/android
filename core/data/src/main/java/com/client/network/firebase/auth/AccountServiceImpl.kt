package com.client.network.firebase.auth

import com.client.model.User
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import java.io.IOException
import javax.inject.Inject

class AccountServiceImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AccountService {

    override val currentUserId: String
        get() = auth.currentUser?.uid.orEmpty()

    override val hasUser: Boolean
        get() = auth.currentUser != null

    override val currentUser: Flow<User>
        get() = callbackFlow {
            val listener =
                FirebaseAuth.AuthStateListener { auth ->
                    this.trySend(auth.currentUser?.let { User(it.uid, it.isAnonymous) } ?: User())
                }
            auth.addAuthStateListener(listener)
            awaitClose { auth.removeAuthStateListener(listener) }
        }

    override suspend fun authenticate(email: String, password: String): AuthResponse {
        return try {
            AuthResponse.Loading
            val response = auth
                .signInWithEmailAndPassword(email, password)
                .await()

            when {
                response.user != null -> {
                    AuthResponse.Success(response.user?.uid ?: response.user?.email.orEmpty())
                }

                else -> AuthResponse.Error("User not found")
            }
        } catch (e: IOException) {
            return AuthResponse.Error(e.message ?: "User not found")
        }
    }

    override suspend fun signUpWithEmail(email: String, password: String): AuthResponse {
        try {
            AuthResponse.Loading
            val response = auth
                .createUserWithEmailAndPassword(email, password)
                .await()

            return when {
                response.user != null -> {
                    AuthResponse.Success(response.user?.uid ?: response.user?.email.orEmpty())
                }

                else -> AuthResponse.Error("Could not create user!")
            }
        } catch (e: IOException) {
            return AuthResponse.Error(e.message ?: "Could not create user!")
        }
    }

    override suspend fun sendRecoveryEmail(email: String) {
        auth.sendPasswordResetEmail(email).await()
    }

    override suspend fun deleteAccount() {
        auth.currentUser
            ?.delete()
            ?.await()
    }

    override suspend fun signOut() {
        if (auth.currentUser!!.isAnonymous) {
            auth.currentUser!!.delete()
        }
        auth.signOut()
    }

    sealed class AuthResponse {
        data object Loading : AuthResponse()
        data class Success(val uid: String) : AuthResponse()
        data class Error(val message: String) : AuthResponse()
    }
}
