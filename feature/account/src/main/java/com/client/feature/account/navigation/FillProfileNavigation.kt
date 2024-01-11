package com.client.feature.account.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.client.common.NavRoutes
import com.client.feature.account.FillProfileRoute

const val fillProfileNavigationRoute = NavRoutes.fillProfileScreen

fun NavController.navigateToFillProfile(navOptions: NavOptions? = null) {
    this.navigate(fillProfileNavigationRoute, navOptions)
}

fun NavGraphBuilder.fillProfileScreen(navController: NavHostController) {
    composable(route = fillProfileNavigationRoute) {
        FillProfileRoute(onContinueClick = {})
    }
}
