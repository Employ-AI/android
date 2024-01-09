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
import com.client.feature.dashboard.components.DashboardHeader
import com.client.feature.dashboard.components.RecentJobsChipRow
import com.client.feature.dashboard.components.RecentJobsRow
import com.client.feature.dashboard.components.RecommendationRow
import com.client.feature.dashboard.components.RecommendedJobItem
import com.client.ui.JobItem

private const val google_icon_url =
    "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/bce91c33647416.56b3aa52abc2d.png"

@Composable
fun DashboardRoute(
    dashboardViewModel: DashboardViewModel = hiltViewModel()
) {
    DashboardScreen()
}

@Composable
internal fun DashboardScreen(
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        item { DashboardHeader() }

        item { RecommendationRow() }

        item {
            LazyRow(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(10) {
                    RecommendedJobItem(
                        positionTitle = "Senior Android Engineer (Remote)",
                        companyName = "Google",
                        companyLogoUrl = google_icon_url,
                        location = "Mountain View, CA",
                        salary = "$150,000 - $200,000",
                        tags = listOf("Remote", "Full Time", "Senior")
                    )
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
    DashboardScreen()
}
