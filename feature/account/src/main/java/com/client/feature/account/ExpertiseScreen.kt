package com.client.feature.account

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.client.common.ExpertiseHelper
import com.client.employ.feature.account.R
import com.client.feature.account.components.ExpertiseItem
import com.client.ui.AccountBaseScreen

@Composable
fun ExpertiseRoute(
    sharedAccountViewModel: SharedAccountViewModel = hiltViewModel(),
    onExpertiseSelected: () -> Unit
) {
    val uiState = sharedAccountViewModel.uiState.collectAsStateWithLifecycle()
    ExpertiseScreen(
        uiState = uiState.value,
        onExpertiseSelected = onExpertiseSelected,
        onContinueClick = sharedAccountViewModel::onExpertiseSelected
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun ExpertiseScreen(
    modifier: Modifier = Modifier,
    uiState: AccountState,
    onExpertiseSelected: () -> Unit,
    onContinueClick: (String) -> Unit
) {
    val selectedExpertise = rememberSaveable { mutableListOf("") }

    AccountBaseScreen(
        pageTitle = R.string.feature_account_what_is_your_expertise,
        description = R.string.feature_account_what_is_your_expertise_description,
        shouldIconBeVisible = false,
        onContinueClick = {
            if (selectedExpertise.isNotEmpty()) {
                onContinueClick(selectedExpertise.joinToString(" "))
            }
        }
    ) {
        FlowColumn(
            modifier = modifier.fillMaxWidth()
        ) {
            val expertiseList = ExpertiseHelper.getExpertises()
            expertiseList.forEach { title ->
                ExpertiseItem(
                    modifier = Modifier.padding(top = 5.dp),
                    title = title,
                    onClick = {
                        if (selectedExpertise.contains(title)) {
                            selectedExpertise.remove(title)
                        } else {
                            selectedExpertise.add(title)
                        }
                    }
                )
            }
        }
    }

    when (uiState) {
        is AccountState.Loading -> Unit
        is AccountState.OnExpertiseSelected -> {
            LaunchedEffect(uiState) {
                onExpertiseSelected()
            }
        }

        else -> Unit
    }
}

@Preview(showBackground = true, apiLevel = 33)
@Composable
private fun ExpertiseScreenPreview() {
    ExpertiseScreen(
        uiState = AccountState.Loading,
        onExpertiseSelected = { },
        onContinueClick = { }
    )
}
