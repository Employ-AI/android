package com.client.feature.onboarding.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.network.firebase.auth.FirebaseAuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val firebaseAuthRepository: FirebaseAuthRepository
) : ViewModel() {

    fun onLoginClick(email: String, password: String) {
        viewModelScope.launch {
            firebaseAuthRepository.login(email, password)
        }
    }
}
