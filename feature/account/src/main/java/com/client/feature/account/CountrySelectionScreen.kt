package com.client.feature.account

import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.common.CountryHelper
import com.client.employ.feature.account.R
import com.client.feature.account.components.CountryItem
import com.client.feature.account.components.SearchTextField

@Composable
fun CountrySelectionRoute(
    onContinueBtnClick: () -> Unit
) {
    CountrySelectionScreen(
        onContinueBtnClick = {}
    )
}

@Composable
internal fun CountrySelectionScreen(
    modifier: Modifier = Modifier,
    onContinueBtnClick: () -> Unit
) {
    val searchQuery = remember { mutableStateOf("") }
    val selectedCountry = rememberSaveable { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            SearchTextField(
                searchQuery = searchQuery
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                item {
                    val countries = CountryHelper.getCountries()
                    CountryItem(
                        countries = countries,
                        selectedItem = { country ->
                            selectedCountry.value = country
                            println("selected country: $country")
                        }
                    )
                }
            }
        }

        Button(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            onClick = onContinueBtnClick
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = stringResource(R.string.feature_account_continue),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CountrySelectionScreenPreview() {
    CountrySelectionScreen(onContinueBtnClick = {})
}