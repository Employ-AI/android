package com.client.employ.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.client.common.NavRoutes
import com.client.feature.account.navigation.countrySelectionScreen
import com.client.feature.dashboard.DashboardRoute
import com.client.feature.onboarding.navigation.forgotPasswordScreen
import com.client.feature.onboarding.navigation.landingScreen
import com.client.feature.onboarding.navigation.loginScreen
import com.client.feature.onboarding.navigation.registerScreen

@Composable
internal fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.countrySelectionScreen,
        modifier = modifier
    ) {
        landingScreen(navController)

        loginScreen(navController)
        registerScreen(navController)
        forgotPasswordScreen(navController)

        dashboardScreen(navController)
        countrySelectionScreen(navController)
    }
}

private fun NavGraphBuilder.dashboardScreen(navController: NavHostController) {
    composable(NavRoutes.mainScreen) {
        DashboardRoute()
    }
}
