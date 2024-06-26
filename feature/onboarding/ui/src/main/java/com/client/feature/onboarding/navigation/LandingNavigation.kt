package com.client.feature.onboarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.client.auth.navigation.navigateToCreateAccount
import com.client.auth.navigation.navigateToLogin
import com.client.common.NavRoutes
import com.client.feature.onboarding.LandingRoute

const val landingNavigationRoute = NavRoutes.LANDING_ROUTE

fun NavController.navigateToLanding(navOptions: NavOptions? = null) {
    this.navigate(landingNavigationRoute, navOptions)
}

fun NavGraphBuilder.landingScreen(navController: NavHostController) {
    composable(route = landingNavigationRoute) {
        LandingRoute(
            onLoginClick = { navController.navigateToLogin() },
            onCreateAccountClick = { navController.navigateToCreateAccount() }
        )
    }
}
