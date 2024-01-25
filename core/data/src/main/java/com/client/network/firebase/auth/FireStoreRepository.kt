package com.client.network.firebase.auth

import com.client.model.User

interface FireStoreRepository {
    fun updateUser(user: User)
}
