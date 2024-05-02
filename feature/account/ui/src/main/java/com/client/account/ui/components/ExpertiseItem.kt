package com.client.account.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ExpertiseItem(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit
) {
    val checked = remember { mutableStateOf(false) }
    OutlinedCard(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        border = BorderStroke(0.5.dp, colorResource(R.color.feature_account_border_color))
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checked.value,
                onCheckedChange = { checked.value = it },
                colors = CheckboxDefaults.colors(
                    disabledCheckedColor = MaterialTheme.colorScheme.primary,
                    disabledUncheckedColor = MaterialTheme.colorScheme.primary
                )
            )

            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ExpertiseItemPreview() {
    ExpertiseItem(
        title = "Android",
        onClick = { /*TODO*/ }
    )
}
