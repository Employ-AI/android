package com.client.network.firebase.auth

import com.client.model.User
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import timber.log.Timber
import javax.inject.Inject

class FireStoreRepositoryImpl @Inject constructor() : FireStoreRepository {

    override fun updateUser(
        user: User,
        authStateCallback: (AuthState) -> Unit
    ) {
        authStateCallback(AuthState.Loading)
        val db = Firebase.firestore
        db.collection(users).document("user")
            .set(user)
            .addOnSuccessListener {
                Timber.e("DocumentSnapshot successfully written!")
                authStateCallback(AuthState.Success(user))
            }
            .addOnFailureListener { e ->
                Timber.e(e, "Error writing document")
                authStateCallback(AuthState.Error(e.message ?: "Error writing document"))
            }
    }

    sealed class AuthState {
        data object Loading : AuthState()
        data class Success(val user: User) : AuthState()
        data class Error(val message: String) : AuthState()
    }

    companion object {
        private const val users = "users"
    }
}
