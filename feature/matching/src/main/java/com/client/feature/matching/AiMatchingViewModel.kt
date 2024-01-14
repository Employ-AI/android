package com.client.feature.matching

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AiMatchingViewModel @Inject constructor() : ViewModel()

sealed interface AiMatchingState {
    data object Idle : AiMatchingState
    data object Matching : AiMatchingState
    data object Matched : AiMatchingState
}
