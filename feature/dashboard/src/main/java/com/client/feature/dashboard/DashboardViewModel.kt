package com.client.feature.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.model.arbit.Data
import com.client.sources.arbeitNow.ArbitNowRepository
import com.client.util.Result.Error
import com.client.util.Result.Loading
import com.client.util.Result.Success
import com.client.util.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    arbitNowRepository: ArbitNowRepository
) : ViewModel() {

    val jobsList = arbitNowRepository.getJobs()
        .asResult()
        .map {
            when (it) {
                is Loading -> DashboardState.Loading
                is Success -> DashboardState.Success(it.data)
                is Error -> DashboardState.Error(it.exception.message ?: "Error")
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = DashboardState.Loading
        )
}

sealed interface DashboardState {
    data object Loading : DashboardState
    data class Success(val jobs: List<Data>) : DashboardState
    data class Error(val message: String) : DashboardState
}
