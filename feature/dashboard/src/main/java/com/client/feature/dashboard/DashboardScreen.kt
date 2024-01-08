package com.client.feature.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.client.feature.dashboard.components.DashboardBody
import com.client.feature.dashboard.components.DashboardHeader

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
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        DashboardHeader()
        DashboardBody()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun DashboardScreenPreview() {
    DashboardScreen()
}
