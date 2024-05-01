package com.client.feature.dashboard.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.client.common.NavRoutes
import com.client.feature.dashboard.DashboardRoute

const val dashboardNavigationRoute = NavRoutes.DASHBOARD_ROUTE

fun NavController.navigateToDashboard(navOptions: NavOptions? = null) {
    this.navigate(dashboardNavigationRoute, navOptions)
}

fun NavGraphBuilder.dashboardScreen(navController: NavHostController) {
    composable(route = dashboardNavigationRoute) {
        DashboardRoute()
    }
}
