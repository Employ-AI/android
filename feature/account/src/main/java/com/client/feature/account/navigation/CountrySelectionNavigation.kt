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

const val countrySelectionNavigationRoute = NavRoutes.COUNTRY_SELECTION_ROUTE

fun NavController.navigateToCountrySelection(navOptions: NavOptions? = null) {
    this.navigate(countrySelectionNavigationRoute, navOptions)
}

fun NavGraphBuilder.countrySelectionScreen(navController: NavHostController) {
    composable(
        route = "${NavRoutes.COUNTRY_SELECTION_ROUTE}/{$UID}",
        arguments = listOf(
            navArgument(name = UID) {
                defaultValue = ""
                nullable = false
            }
        )
    ) { backStackEntry ->
        val uid = backStackEntry.arguments?.getString(UID) ?: ""
        CountrySelectionRoute(
            onContinueBtnClick = { selectedCountry ->
                navController.navigate(NavRoutes.CHOOSE_JOB_TYPE_ROUTE + "/$uid" + "/$selectedCountry")
            }
        )
    }
}
