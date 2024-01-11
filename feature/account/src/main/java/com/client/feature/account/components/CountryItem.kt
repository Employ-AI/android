package com.client.feature.account.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun CountryItem(
    modifier: Modifier = Modifier,
    countries: List<String>,
    selectedItem: (String) -> Unit
) {
    val selectedOption = remember { mutableStateOf(countries[0]) }
    countries.forEach { country ->
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable {
                    selectedOption.value = country
                    selectedItem(country)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = (country == selectedOption.value),
                onClick = {
                    selectedOption.value = country
                    selectedItem(country)
                }
            )
            Text(
                text = country,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountryItemPreview() {
    CountryItem(
        countries = listOf("Iran", "USA", "UK"),
        selectedItem = {}
    )
}
