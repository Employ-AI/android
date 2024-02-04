package com.client.feature.account.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.client.common.COUNTRY
import com.client.common.EXPERTISE
import com.client.common.JOB_TYPE
import com.client.common.NavRoutes
import com.client.common.UID
import com.client.feature.account.FillProfileRoute

const val fillProfileNavigationRoute = NavRoutes.FILL_PROFILE_ROUTE

fun NavController.navigateToFillProfile(navOptions: NavOptions? = null) {
    this.navigate(fillProfileNavigationRoute, navOptions)
}

fun NavGraphBuilder.fillProfileScreen(navController: NavHostController) {
    composable(
        route = "${NavRoutes.FILL_PROFILE_ROUTE}/{$UID}/{$COUNTRY}/{$JOB_TYPE}/{$EXPERTISE}",
        arguments = listOf(
            navArgument(UID) {
                defaultValue = ""
                nullable = false
            },
            navArgument(COUNTRY) {
                defaultValue = ""
                nullable = false
            },
            navArgument(JOB_TYPE) {
                defaultValue = ""
                nullable = false
            },
        )
    ) { backStackEntry ->
        val uid = backStackEntry.arguments?.getString(UID) ?: ""
        FillProfileRoute(
            onProfileFilled = {
                navController.navigate(NavRoutes.DASHBOARD_ROUTE + "/$uid")
            }
        )
    }
}
