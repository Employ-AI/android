package com.client.network.firebase.auth

import com.client.model.User
import com.client.network.firebase.auth.FireStoreRepositoryImpl.AuthState

interface FireStoreRepository {
    fun updateUser(
        user: User,
        authStateCallback: (AuthState) -> Unit
    )
}
