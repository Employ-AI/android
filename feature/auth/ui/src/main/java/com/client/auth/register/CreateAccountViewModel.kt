package com.client.auth.register

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
class CreateAccountViewModel @Inject constructor(
    private val accountService: AccountService
) : ViewModel() {

    private val _registerState: MutableStateFlow<RegisterState> =
        MutableStateFlow(RegisterState.Loading)
    val registerState = _registerState.asStateFlow()

    fun onSignUpClicked(email: String, password: String) {
        viewModelScope.launch {
            _registerState.value =
                when (val result = accountService.signUpWithEmail(email, password)) {
                    is AuthResponse.Loading -> RegisterState.Loading
                    is AuthResponse.Success -> RegisterState.Success(result.uid)
                    is AuthResponse.Error -> RegisterState.Error(result.message)
                }
        }
    }
}

sealed interface RegisterState {
    data object Loading : RegisterState
    data class Success(val uid: String) : RegisterState
    data class Error(val message: String) : RegisterState
}
