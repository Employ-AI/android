package com.client.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.network.firebase.auth.AccountService
import com.client.network.firebase.auth.AccountServiceImpl.AuthResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val accountService: AccountService
) : ViewModel() {

    private val _authState: MutableStateFlow<LoginState> = MutableStateFlow(LoginState.Initial)
    val authState = _authState.asStateFlow()

    fun onLoginClick(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = when (val result = accountService.authenticate(email, password)) {
                is AuthResponse.Loading -> LoginState.Loading
                is AuthResponse.Success -> LoginState.Success(result.uid)
                is AuthResponse.Error -> LoginState.Error(result.message)
            }
        }
    }
}

sealed interface LoginState {
    data object Initial : LoginState
    data object Loading : LoginState
    data class Success(val uid: String) : LoginState
    data class Error(val message: String) : LoginState
}
