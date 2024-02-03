package com.client.feature.account.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.client.common.NavRoutes
import com.client.common.UID
import com.client.feature.account.CountrySelectionRoute

const val countrySelectionNavigationRoute = NavRoutes.countrySelectionScreen

fun NavController.navigateToCountrySelection(navOptions: NavOptions? = null) {
    this.navigate(countrySelectionNavigationRoute, navOptions)
}

fun NavGraphBuilder.countrySelectionScreen(navController: NavHostController) {
    composable(
        route = "${NavRoutes.countrySelectionScreen}/{$UID}",
        arguments = listOf(
            navArgument(name = UID) {
                defaultValue = ""
                nullable = false
            }
        )
    ) { backStackEntry ->
        val uid = backStackEntry.arguments?.getString(UID) ?: ""
        CountrySelectionRoute(
            onCountrySelected = { navController.navigate(NavRoutes.chooseJobTypeScreen + "/$uid") }
        )
    }
}
