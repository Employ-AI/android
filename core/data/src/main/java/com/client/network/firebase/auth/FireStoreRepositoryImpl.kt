package com.client.network.firebase.auth

import android.util.Log
import com.client.model.User
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import javax.inject.Inject

class FireStoreRepositoryImpl @Inject constructor() : FireStoreRepository {

    override fun updateUser(user: User) {
        val db = Firebase.firestore
        db.collection(users).document("user")
            .set(user)
            .addOnSuccessListener { Log.d("TAG", "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w("TAG", "Error writing document", e) }
    }

    sealed class AuthState {
        data class Success(val data: User) : AuthState()
        data class Error(val message: String) : AuthState()
    }

    companion object {
        private const val users = "users"
    }
}
