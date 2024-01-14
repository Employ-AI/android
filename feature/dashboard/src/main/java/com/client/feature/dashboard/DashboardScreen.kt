package com.client.feature.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.client.feature.dashboard.components.DashboardHeader
import com.client.feature.dashboard.components.RecentJobsChipRow
import com.client.feature.dashboard.components.RecentJobsRow
import com.client.feature.dashboard.components.RecommendationRow
import com.client.feature.dashboard.components.RecommendedJobItem
import com.client.ui.JobItem

@Composable
fun DashboardRoute(
    dashboardViewModel: DashboardViewModel = hiltViewModel()
) {
    val jobsState = dashboardViewModel.jobsList.collectAsStateWithLifecycle()
    DashboardScreen(
        jobsState = jobsState.value
    )
}

@Composable
internal fun DashboardScreen(
    modifier: Modifier = Modifier,
    jobsState: DashboardState
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        item { DashboardHeader() }

        item { RecommendationRow() }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(10) {
                    when (jobsState) {
                        is DashboardState.Loading -> Unit
                        is DashboardState.Success -> {
                            RecommendedJobItem(
                                positionTitle = jobsState.jobs[it].title,
                                companyName = jobsState.jobs[it].companyName,
                                companyLogoUrl = jobsState.jobs[it].description,
                                location = jobsState.jobs[it].location,
                                salary = jobsState.jobs[it].slug,
                                tags = jobsState.jobs[it].tags
                            )
                        }
                        else -> Unit
                    }
                }
            }
        }

        item { RecentJobsRow() }

        item { RecentJobsChipRow() }

        item { JobsList() }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun JobsList(
    modifier: Modifier = Modifier
) {
    FlowColumn(
        modifier = modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        repeat(10) {
            JobItem(
                positionTitle = "Senior Android Engineer (Remote)",
                companyName = "Google",
                companyLogoUrl = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png",
                location = "Mountain View, CA",
                salary = "$150,000 - $200,000",
                tags = listOf("Remote", "Full Time", "Senior")
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    apiLevel = 33
)
@Composable
private fun DashboardScreenPreview() {
    DashboardScreen(jobsState = DashboardState.Success(listOf()))
}
