package com.client.feature.account

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.employ.feature.account.R
import com.client.feature.account.components.ExpertiseItem
import com.client.ui.AccountBaseScreen
import com.client.employ.core.ui.R as CoreUiR

@Composable
fun ExpertiseRoute(
    onContinueClick: (String) -> Unit
) {
    ExpertiseScreen(
        onContinueClick = onContinueClick
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun ExpertiseScreen(
    modifier: Modifier = Modifier,
    onContinueClick: (String) -> Unit
) {
    val selectedExpertise = rememberSaveable { mutableListOf("") }
    val context = LocalContext.current
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
            val expertiseList =
                context.resources.getStringArray(CoreUiR.array.core_ui_expertise_areas).toList()
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
}

@Preview(showBackground = true, apiLevel = 33)
@Composable
private fun ExpertiseScreenPreview() {
    ExpertiseScreen(
        onContinueClick = { }
    )
}
