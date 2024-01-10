package com.client.feature.onboarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.client.common.NavRoutes
import com.client.feature.onboarding.auth.login.LoginRoute
import com.client.feature.onboarding.auth.register.RegisterRoute

const val loginNavigationRoute = NavRoutes.loginRoute
const val registerNavigationRoute = NavRoutes.registerRoute

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(loginNavigationRoute, navOptions)
}

fun NavGraphBuilder.loginScreen(navController: NavHostController) {
    composable(route = loginNavigationRoute) {
        LoginRoute(
            onDontHaveAnAccountClick = {},
            onForgotPassClick = {}
        )
    }
}

fun NavController.navigateToRegister(navOptions: NavOptions? = null) {
    this.navigate(registerNavigationRoute, navOptions)
}

fun NavGraphBuilder.registerScreen(navController: NavHostController) {
    composable(route = registerNavigationRoute) {
        RegisterRoute(
            onAlreadyAccountExistClick = { navController.navigate(NavRoutes.loginRoute) }
        )
    }
}
