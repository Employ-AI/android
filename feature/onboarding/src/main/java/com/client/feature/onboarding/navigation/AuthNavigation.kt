package com.client.feature.onboarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.client.common.NavRoutes
import com.client.feature.onboarding.auth.LoginRoute

const val loginNavigationRoute = NavRoutes.loginRoute

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(loginNavigationRoute, navOptions)
}

fun NavGraphBuilder.dashboardScreen(navController: NavHostController) {
    composable(route = loginNavigationRoute) {
        LoginRoute()
    }
}