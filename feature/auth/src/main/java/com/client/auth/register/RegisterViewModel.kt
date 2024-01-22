package com.client.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.network.firebase.auth.AccountService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val accountService: AccountService
) : ViewModel() {

    private val _registerState: MutableStateFlow<RegisterState> =
        MutableStateFlow(RegisterState.Loading)
    val registerState = _registerState.asStateFlow()

    fun onSignUpClicked(email: String, password: String) {
        viewModelScope.launch {
            val response = accountService.signUpWithEmail(email, password)
            println("$response")
        }
    }
}

sealed interface RegisterState {
    data object Loading : RegisterState
    data class Success(val result: String) : RegisterState
    data class Error(val error: String) : RegisterState
}
