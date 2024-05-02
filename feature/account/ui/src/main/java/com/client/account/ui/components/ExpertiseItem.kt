package com.client.account.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.employ.feature.account.ui.R

@Composable
internal fun ExpertiseItem(
    modifier: Modifier = Modifier,
    expertiseList: List<String>,
    selectedItem: (String) -> Unit,
) {
    val selectedOption = remember { mutableStateOf(expertiseList[0]) }
    expertiseList.forEach { expertise ->
        OutlinedCard(
            modifier = modifier.fillMaxWidth(),
            onClick = {
                selectedOption.value = expertise
                selectedItem(expertise)
            },
            border = BorderStroke(0.5.dp, colorResource(R.color.feature_account_border_color))
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedOption.value == expertise,
                    onClick = {
                        selectedOption.value = expertise
                        selectedItem(expertise)
                    }
                )

                Text(
                    text = expertise,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ExpertiseItemPreview() {
    ExpertiseItem(
        expertiseList = listOf("Android", "iOS", "Web"),
        selectedItem = {}
    )
}
