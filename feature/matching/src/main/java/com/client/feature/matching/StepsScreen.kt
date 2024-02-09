package com.client.feature.matching

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.client.employ.feature.matching.R
import com.client.ui.BaseScrollableScreen
import com.client.ui.components.Step
import com.client.ui.components.StepItem
import com.client.ui.components.VerticalLine

@Composable
fun ProgressStepsRoute(
    navController: NavHostController
) {
    ProgressStepsScreen()
}

@Composable
internal fun ProgressStepsScreen(
    modifier: Modifier = Modifier,
) {
    BaseScrollableScreen(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(R.drawable.onboarding_icon),
            contentDescription = null
        )

        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = stringResource(R.string.feature_matching_onboarding_progress),
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = stringResource(R.string.feature_matching_complete_your_profile_to_get_started),
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        ProgressSteps()
    }
}

@Composable
fun ProgressSteps() {
    val steps: List<Step> = listOf(
        Step(
            title = stringResource(R.string.feature_matching_step_1),
            description = stringResource(R.string.feature_matching_basic_information),
            isCompleted = true,
            selectedStepColor = MaterialTheme.colorScheme.primary,
            unSelectedStepColor = Color.LightGray,
            number = 1
        ),
        Step(
            title = stringResource(R.string.feature_matching_step_2),
            description = stringResource(R.string.feature_matching_complete_your_profile),
            isCompleted = true,
            selectedStepColor = MaterialTheme.colorScheme.primary,
            unSelectedStepColor = Color.LightGray,
            number = 2
        ),
        Step(
            title = stringResource(R.string.feature_matching_step_3),
            description = stringResource(R.string.feature_matching_onboarding),
            isCompleted = false,
            selectedStepColor = MaterialTheme.colorScheme.primary,
            unSelectedStepColor = Color.LightGray,
            number = 3
        ),
        Step(
            title = stringResource(R.string.feature_matching_step_4),
            description = stringResource(id = R.string.feature_matching_complete_your_profile_to_get_started),
            isCompleted = false,
            selectedStepColor = MaterialTheme.colorScheme.primary,
            unSelectedStepColor = Color.LightGray,
            number = 4
        )
    )

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        steps.forEachIndexed { index, step ->
            StepItem(step = step)

            if (index < steps.size - 1) {
                Spacer(modifier = Modifier.height(4.dp))
                VerticalLine(isCompleted = steps[index + 1].isCompleted)
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun ProgressStepsPreview() {
    ProgressStepsScreen()
}
