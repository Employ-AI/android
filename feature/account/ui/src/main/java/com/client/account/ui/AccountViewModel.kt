package com.client.account.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.common.COUNTRY
import com.client.common.EXPERTISE
import com.client.common.JOB_TYPE
import com.client.common.UID
import com.client.model.User
import com.client.network.firebase.auth.FireStoreRepository
import com.client.network.firebase.auth.FireStoreRepositoryImpl.AuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val fireStoreRepository: FireStoreRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState: MutableStateFlow<AccountState> = MutableStateFlow(AccountState.Initial)
    val uiState = _uiState.asStateFlow()
    private val uid = savedStateHandle.get<String>(UID) ?: ""
    private val country = savedStateHandle.get<String>(COUNTRY) ?: ""
    private val jobType = savedStateHandle.get<String>(JOB_TYPE) ?: ""
    private val expertise = savedStateHandle.get<String>(EXPERTISE) ?: ""

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
                    gender = userProfile.gender,
                    country = country,
                    jobType = jobType,
                    expertise = expertise
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
    data object Initial : AccountState
    data object Loading : AccountState
    data object OnProfileFilled : AccountState
    data object Error : AccountState
}
