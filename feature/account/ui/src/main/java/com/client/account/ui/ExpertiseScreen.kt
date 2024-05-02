package com.client.account.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.account.ui.components.ExpertiseItem
import com.client.employ.feature.account.ui.R
import com.client.employ.core.ui.R as CoreUiR

@Composable
fun ExpertiseRoute(
    onContinueClick: (String) -> Unit
) {
    ExpertiseScreen(
        onContinueClick = onContinueClick
    )
}

@Composable
internal fun ExpertiseScreen(
    modifier: Modifier = Modifier,
    onContinueClick: (String) -> Unit
) {
    val selectedExpertise = rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        modifier = modifier.padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.feature_account_what_is_your_expertise),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = stringResource(R.string.feature_account_what_is_your_expertise_description),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )

        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            item {
                val expertiseList =
                    context.resources.getStringArray(CoreUiR.array.core_ui_expertise_areas).toList()
                ExpertiseItem(
                    modifier = Modifier.padding(top = 5.dp),
                    expertiseList = expertiseList,
                    selectedItem = { title ->
                        selectedExpertise.value = title
                    }
                )
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            onClick = {
                if (selectedExpertise.value.isNotEmpty()) {
                    onContinueClick(selectedExpertise.value)
                }
            }
        ) {
            Text(
                text = stringResource(CoreUiR.string.core_ui_continue),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
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
