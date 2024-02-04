package com.client.employ.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.client.auth.navigation.forgotPasswordScreen
import com.client.auth.navigation.loginScreen
import com.client.auth.navigation.registerScreen
import com.client.common.NavRoutes
import com.client.feature.account.navigation.chooseJobTypeScreen
import com.client.feature.account.navigation.countrySelectionScreen
import com.client.feature.account.navigation.expertiseScreen
import com.client.feature.account.navigation.fillProfileScreen
import com.client.feature.dashboard.DashboardRoute
import com.client.feature.matching.navigation.aiMatchingScreen
import com.client.feature.onboarding.navigation.landingScreen

@Composable
internal fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.LANDING_SCREEN,
        modifier = modifier
    ) {
        landingScreen(navController)

        // Auth
        loginScreen(navController)
        registerScreen(navController)
        forgotPasswordScreen(navController)

        dashboardScreen(navController)

        // Account setup
        countrySelectionScreen(navController)
        chooseJobTypeScreen(navController)
        expertiseScreen(navController)
        fillProfileScreen(navController)

        // Matching
        aiMatchingScreen(navController)
    }
}

private fun NavGraphBuilder.dashboardScreen(navController: NavHostController) {
    composable(NavRoutes.DASHBOARD_ROUTE) {
        DashboardRoute()
    }
}
