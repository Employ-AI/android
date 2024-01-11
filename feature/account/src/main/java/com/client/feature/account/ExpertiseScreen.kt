package com.client.feature.account

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.common.ExpertiseHelper
import com.client.employ.feature.account.R
import com.client.feature.account.components.ExpertiseItem
import com.client.ui.AccountBaseScreen

@Composable
fun ExpertiseRoute(
    onContinueClick: () -> Unit
) {
    ExpertiseScreen(
        onContinueClick = onContinueClick
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun ExpertiseScreen(
    modifier: Modifier = Modifier,
    onContinueClick: () -> Unit
) {
    AccountBaseScreen(
        pageTitle = R.string.feature_account_what_is_your_expertise,
        description = R.string.feature_account_what_is_your_expertise_description,
        shouldIconBeVisible = false,
        onContinueClick = onContinueClick
    ) {
        FlowColumn(
            modifier = modifier.fillMaxWidth()
        ) {
            val expertiseList = ExpertiseHelper.getExpertises()
            expertiseList.forEachIndexed { _, title ->
                ExpertiseItem(
                    modifier = Modifier.padding(top = 5.dp),
                    title = title,
                    onClick = { /*TODO*/ }
                )
            }
        }
    }
}

@Preview(showBackground = true, apiLevel = 33)
@Composable
private fun ExpertiseScreenPreview() {
    ExpertiseScreen(
        onContinueClick = { /*TODO*/ }
    )
}
