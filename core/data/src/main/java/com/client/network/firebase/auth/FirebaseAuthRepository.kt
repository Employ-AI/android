package com.client.network.firebase.auth

import com.client.model.User

interface FirebaseAuthRepository {
    suspend fun login(email: String, password: String)
    fun addUser(user: User)
    fun updateUser(user: User)
}
