package com.client.feature.matching

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.client.employ.feature.matching.R
import com.client.feature.matching.components.ProgressSteps
import com.client.ui.BaseScrollableScreen

@Composable
fun StepsRoute(
    navController: NavHostController
) {
    StepsScreen()
}

@Composable
internal fun StepsScreen(
    modifier: Modifier = Modifier,
) {
    BaseScrollableScreen(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier.size(width = 225.dp, height = 210.dp),
            painter = painterResource(R.drawable.onboarding_icon),
            contentDescription = null
        )

        Text(
            text = stringResource(R.string.feature_matching_onboarding_progress),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = stringResource(R.string.feature_matching_complete_your_profile_to_get_started),
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        ProgressSteps()

        // Spacer(modifier = Modifier.weight(1f))

        /*Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            onClick = {  }
        ) {
            Text(
                text = stringResource(R.string.feature_matching_finish_onboarding),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        }*/
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun StepsPreview() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StepsScreen()
    }
}
