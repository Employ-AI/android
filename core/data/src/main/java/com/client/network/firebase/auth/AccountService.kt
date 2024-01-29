package com.client.network.firebase.auth

import com.client.model.User
import com.client.network.firebase.auth.AccountServiceImpl.AuthResponse
import kotlinx.coroutines.flow.Flow

interface AccountService {
    val currentUserId: String
    val hasUser: Boolean
    val currentUser: Flow<User>

    suspend fun authenticate(email: String, password: String): AuthResponse
    suspend fun signUpWithEmail(email: String, password: String): AuthResponse

    suspend fun sendRecoveryEmail(email: String)
    suspend fun deleteAccount()
    suspend fun signOut()
}
