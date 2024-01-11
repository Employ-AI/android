package com.client.feature.account.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.client.common.NavRoutes
import com.client.feature.account.CountrySelectionRoute

const val countrySelectionNavigationRoute = NavRoutes.countrySelectionScreen

fun NavController.navigateToCountrySelection(navOptions: NavOptions? = null) {
    this.navigate(countrySelectionNavigationRoute, navOptions)
}

fun NavGraphBuilder.countrySelectionScreen(navController: NavHostController) {
    composable(route = countrySelectionNavigationRoute) {
        CountrySelectionRoute(
            onContinueBtnClick = { navController.navigateToChooseJobType() }
        )
    }
}
