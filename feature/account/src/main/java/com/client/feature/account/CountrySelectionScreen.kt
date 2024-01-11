package com.client.feature.account

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SearchTextField(
            searchQuery = searchQuery
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = modifier.fillMaxWidth()
        ) {
            items(10) {
                CountryItem(selectedItem = {})
            }
        }

        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = modifier.fillMaxWidth(),
                onClick = onContinueBtnClick
            ) {
                Text(
                    modifier = modifier.padding(8.dp),
                    text = stringResource(R.string.feature_account_continue)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CountrySelectionScreenPreview() {
    CountrySelectionScreen(onContinueBtnClick = {})
}