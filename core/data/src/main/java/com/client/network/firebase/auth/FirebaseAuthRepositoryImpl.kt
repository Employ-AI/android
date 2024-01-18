package com.client.network.firebase.auth

import android.util.Log
import com.client.model.User
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore
import javax.inject.Inject

class FirebaseAuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : FirebaseAuthRepository {

    override suspend fun login(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    Log.d("TAG", "signInWithEmail:success $user")
                } else {
                    Log.w("TAG", "signInWithEmail:failure", task.exception)
                }
            }
    }

    override fun addUser(user: User) {
        val db = Firebase.firestore
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("TAG", "Error adding document", e)
            }
    }

    override fun updateUser(user: User) {
        val db = Firebase.firestore
        db.collection("users").document("user")
            .set(user)
            .addOnSuccessListener { Log.d("TAG", "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w("TAG", "Error writing document", e) }
    }

    sealed class AuthState {
        data class Success(val data: User) : AuthState()
        data class Error(val message: String) : AuthState()
    }
}
