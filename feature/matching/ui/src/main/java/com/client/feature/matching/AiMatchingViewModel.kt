package com.client.feature.matching

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.client.Dispatcher
import com.client.EmployDispatchers.IO
import com.client.account.data.MediaPipeEmbeddings
import com.client.model.JobSimilarity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AiMatchingViewModel @Inject constructor(
    @Dispatcher(IO) private val ioDispatcher: CoroutineDispatcher,
    private val mediaPipeEmbeddings: MediaPipeEmbeddings
) : ViewModel() {

    private var uiState by mutableStateOf(TextEmbeddingsUiState(state = AiMatchingState.Empty))

    init {
        setUpMLModel()
        // TODO: Get the user info and jobs to match later
    }

    private fun setUpMLModel() {
        uiState = uiState.copy(
            state = AiMatchingState.Loading,
            similarities = emptyList()
        )

        viewModelScope.launch {
            mediaPipeEmbeddings.setUpMLModel()

            uiState = uiState.copy(
                jobs = listOf(
                    "The next weekend will be your birthday",
                    "Birds sing in the morning",
                    "My cat sleeps a lot",
                ),
                // TODO: Get the user info and jobs to match later
                state = AiMatchingState.Empty
            )
        }
    }

    fun calculateSimilarity(
        mainSentence: String,
        sentences: List<String>
    ) {
        uiState = uiState.copy(
            state = AiMatchingState.Loading,
            similarities = emptyList()
        )

        viewModelScope.launch(ioDispatcher) {
            uiState = try {
                val similarities = mediaPipeEmbeddings.getSimilarities(mainSentence, sentences)

                uiState.copy(
                    state = AiMatchingState.Success,
                    similarities = similarities
                )
            } catch (e: Exception) {
                uiState.copy(
                    state = AiMatchingState.Error,
                    errorMessage = e.message ?: "Error getting similarities"
                )
            }
        }
    }
}

sealed interface AiMatchingState {
    data object Loading : AiMatchingState
    data object Success : AiMatchingState
    data object Error : AiMatchingState
    data object Empty : AiMatchingState
}

@Stable
data class TextEmbeddingsUiState(
    val jobs: List<String> = emptyList(),
    val similarities: List<JobSimilarity> = emptyList(),
    val state: AiMatchingState = AiMatchingState.Empty,
    val errorMessage: String = String()
)
