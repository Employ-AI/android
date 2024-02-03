package com.client.feature.account

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.model.User
import com.client.network.firebase.auth.FireStoreRepository
import com.client.network.firebase.auth.FireStoreRepositoryImpl.AuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedAccountViewModel @Inject constructor(
    private val fireStoreRepository: FireStoreRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState: MutableStateFlow<AccountState> = MutableStateFlow(AccountState.Loading)
    val uiState = _uiState.asStateFlow()
    private val uid = savedStateHandle.get<String>("uid") ?: ""

    fun setCountry(country: String) {
        viewModelScope.launch {
            fireStoreRepository.updateUser(
                user = User(id = uid, country = country),
                authStateCallback = { authState ->
                    when (authState) {
                        is AuthState.Loading -> _uiState.value = AccountState.Loading
                        is AuthState.Success -> _uiState.value = AccountState.OnCountrySelected
                        is AuthState.Error -> _uiState.value = AccountState.Error
                    }
                }
            )
        }
    }

    fun onJobTypeSelected(jobType: String) {
        viewModelScope.launch {
            AccountState.Loading
            fireStoreRepository.updateUser(
                user = User(id = uid, jobType = jobType),
                authStateCallback = { authState ->
                    when (authState) {
                        is AuthState.Loading -> _uiState.value = AccountState.Loading
                        is AuthState.Success -> _uiState.value = AccountState.OnJobTypeSelected
                        is AuthState.Error -> _uiState.value = AccountState.Error
                    }
                }
            )
        }
    }

    fun onExpertiseSelected(expertise: String) {
        viewModelScope.launch {
            fireStoreRepository.updateUser(
                user = User(id = uid, expertise = expertise),
                authStateCallback = { authState ->
                    when (authState) {
                        is AuthState.Loading -> _uiState.value = AccountState.Loading
                        is AuthState.Success -> _uiState.value = AccountState.OnExpertiseSelected
                        is AuthState.Error -> _uiState.value = AccountState.Error
                    }
                }
            )
        }
    }

    fun onProfileFilled(userProfile: UserProfile) {
        viewModelScope.launch {
            fireStoreRepository.updateUser(
                user = User(
                    id = uid,
                    fullName = userProfile.fullName,
                    nickName = userProfile.nickName,
                    dateOfBirth = userProfile.dateOfBirth,
                    email = userProfile.email,
                    phoneNumber = userProfile.phone,
                    gender = userProfile.gender
                ),
                authStateCallback = { authState ->
                    when (authState) {
                        is AuthState.Loading -> _uiState.value = AccountState.Loading
                        is AuthState.Success -> _uiState.value = AccountState.OnProfileFilled
                        is AuthState.Error -> _uiState.value = AccountState.Error
                    }
                }
            )
        }
    }
}

sealed interface AccountState {
    data object Loading : AccountState
    data object OnCountrySelected : AccountState
    data object OnJobTypeSelected : AccountState
    data object OnExpertiseSelected : AccountState
    data object OnProfileFilled : AccountState
    data object Error : AccountState
}
