package com.client.feature.account.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.client.common.NavRoutes
import com.client.common.UID
import com.client.feature.account.FillProfileRoute

const val fillProfileNavigationRoute = NavRoutes.fillProfileScreen

fun NavController.navigateToFillProfile(navOptions: NavOptions? = null) {
    this.navigate(fillProfileNavigationRoute, navOptions)
}

fun NavGraphBuilder.fillProfileScreen(navController: NavHostController) {
    composable(
        route = "${NavRoutes.fillProfileScreen}/{$UID}",
        arguments = listOf(
            navArgument(UID) {
                defaultValue = ""
                nullable = false
            }
        )
    ) { backStackEntry ->
        val uid = backStackEntry.arguments?.getString(UID) ?: ""
        FillProfileRoute(
            onProfileFilled = {
                navController.navigate(NavRoutes.dashboardRoute + "/$uid")
            }
        )
    }
}
