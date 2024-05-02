package com.client.employ.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.client.account.ui.navigation.chooseJobTypeScreen
import com.client.account.ui.navigation.countrySelectionScreen
import com.client.account.ui.navigation.expertiseScreen
import com.client.account.ui.navigation.fillProfileScreen
import com.client.account.ui.navigation.interestsScreen
import com.client.auth.navigation.createAccountScreen
import com.client.auth.navigation.forgotPasswordScreen
import com.client.auth.navigation.loginScreen
import com.client.common.NavRoutes
import com.client.feature.dashboard.DashboardRoute
import com.client.feature.matching.navigation.aiMatchingScreen
import com.client.feature.matching.navigation.stepsScreen
import com.client.feature.onboarding.navigation.landingScreen

@Composable
internal fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    isFirstLogin: Boolean
) {
    NavHost(
        navController = navController,
        startDestination = if (isFirstLogin) NavRoutes.LANDING_ROUTE else NavRoutes.DASHBOARD_ROUTE,
        modifier = modifier
    ) {
        landingScreen(navController)

        // Auth
        loginScreen(navController)
        createAccountScreen(navController)
        forgotPasswordScreen(navController)

        dashboardScreen(navController)

        // Account setup
        countrySelectionScreen(navController)
        chooseJobTypeScreen(navController)
        expertiseScreen(navController)
        fillProfileScreen(navController)
        interestsScreen(navController)

        // Matching
        aiMatchingScreen(navController)

        stepsScreen(navController)
    }
}

private fun NavGraphBuilder.dashboardScreen(navController: NavHostController) {
    composable(NavRoutes.DASHBOARD_ROUTE) {
        DashboardRoute()
    }
}
