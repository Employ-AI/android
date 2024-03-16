package com.client.feature.account.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.client.common.COUNTRY
import com.client.common.NavRoutes
import com.client.common.UID
import com.client.feature.account.ChooseJobTypeRoute

const val chooseJobTypeNavigation = NavRoutes.CHOOSE_JOB_TYPE_ROUTE

fun NavController.navigateToChooseJobType(navOptions: NavOptions? = null) {
    this.navigate(chooseJobTypeNavigation, navOptions)
}

fun NavGraphBuilder.chooseJobTypeScreen(navController: NavHostController) {
    composable(
        route = "${NavRoutes.CHOOSE_JOB_TYPE_ROUTE}/{$UID}/{$COUNTRY}",
        arguments = listOf(
            navArgument(UID) {
                defaultValue = ""
                nullable = false
            },
            navArgument(COUNTRY) {
                defaultValue = ""
                nullable = false
            }
        )
    ) { backStackEntry ->
        val uid = backStackEntry.arguments?.getString(UID) ?: ""
        val selectedCountry = backStackEntry.arguments?.getString(COUNTRY) ?: ""

        ChooseJobTypeRoute(
            onContinueClick = { selectedJobType ->
                navController.navigate(NavRoutes.INTERESTS_ROUTE + "/$uid" + "/$selectedCountry" + "/$selectedJobType")
            }
        )
    }
}
