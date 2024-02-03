package com.client.feature.account.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.client.common.NavRoutes
import com.client.common.UID
import com.client.feature.account.ExpertiseRoute

const val expertiseScreenNavigationRoute = NavRoutes.expertiseScreen

fun NavController.navigateToExpertiseScreen(navOptions: NavOptions? = null) {
    this.navigate(expertiseScreenNavigationRoute, navOptions)
}

fun NavGraphBuilder.expertiseScreen(navController: NavHostController) {
    composable(
        route = "${NavRoutes.expertiseScreen}/{$UID}",
        arguments = listOf(
            navArgument(UID) {
                defaultValue = ""
                nullable = false
            }
        )
    ) { backStackEntry ->
        val uid = backStackEntry.arguments?.getString(UID) ?: ""
        ExpertiseRoute(
            onExpertiseSelected = {
                navController.navigate(NavRoutes.fillProfileScreen + "/$uid")
            }
        )
    }
}
