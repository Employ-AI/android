package com.client.feature.account

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.client.employ.feature.account.R
import com.client.ui.BaseCenterColumn
import com.client.employ.core.ui.R as CoreUiR

@Composable
fun InterestsRoute(
    navController: NavHostController
) {
    InterestsScreen()
}

@Composable
internal fun InterestsScreen(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.feature_account_interests),
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.feature_account_you_can_select_up_to_5_interests),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalStaggeredGrid(
            modifier = Modifier.fillMaxWidth(),
            columns = StaggeredGridCells.Fixed(3),
        ) {
            val techItems =
                context.resources.getStringArray(CoreUiR.array.core_ui_tech_interests).toList()
            items(techItems.size) { index ->
                InterestItem(
                    interest = techItems[index],
                    onInterestClick = { /*TODO*/ }
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(48.dp),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = stringResource(R.string.feature_account_continue)
            )
        }
    }
}

@Composable
private fun InterestItem(
    interest: String,
    onInterestClick: (String) -> Unit
) {
    SuggestionChip(
        modifier = Modifier.padding(4.dp),
        onClick = { onInterestClick(interest) },
        label = {
            Text(
                text = interest,
                textAlign = TextAlign.Center
            )
        },
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            labelColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun InterestsScreenPreview() {
    BaseCenterColumn {
        InterestsScreen()
    }
}