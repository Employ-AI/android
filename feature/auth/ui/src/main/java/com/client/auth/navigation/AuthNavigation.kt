package com.client.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.client.auth.forgot.ForgotPass
import com.client.auth.login.LoginRoute
import com.client.auth.register.CreateAccountRoute
import com.client.common.NavRoutes

const val loginNavigationRoute = NavRoutes.LOGIN_ROUTE
const val createAccountNavigationRoute = NavRoutes.REGISTER_ROUTE
const val forgotPassNavigationRoute = NavRoutes.FORGOT_PASSWORD_ROUTE

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(loginNavigationRoute, navOptions)
}

fun NavGraphBuilder.loginScreen(navController: NavHostController) {
    composable(route = loginNavigationRoute) {
        LoginRoute(
            onNotHaveAnAccountClick = { navController.navigateToCreateAccount() },
            onForgotPassClick = { navController.navigateToForgotPassword() },
            onLoginSuccess = { uid ->
                navController.navigate(route = NavRoutes.COUNTRY_SELECTION_ROUTE + "/$uid")
            }
        )
    }
}

fun NavController.navigateToCreateAccount(navOptions: NavOptions? = null) {
    this.navigate(createAccountNavigationRoute, navOptions)
}

fun NavGraphBuilder.createAccountScreen(navController: NavHostController) {
    composable(route = createAccountNavigationRoute) {
        CreateAccountRoute(
            onAlreadyAccountExistClick = { navController.navigate(NavRoutes.LOGIN_ROUTE) }
        )
    }
}

fun NavController.navigateToForgotPassword(navOptions: NavOptions? = null) {
    this.navigate(forgotPassNavigationRoute, navOptions)
}

fun NavGraphBuilder.forgotPasswordScreen(navController: NavHostController) {
    composable(route = forgotPassNavigationRoute) {
        ForgotPass()
    }
}
