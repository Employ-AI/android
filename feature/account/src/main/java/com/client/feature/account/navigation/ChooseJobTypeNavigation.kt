package com.client.feature.account.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.client.common.NavRoutes
import com.client.feature.account.ChooseJobTypeRoute

const val chooseJobTypeNavigation = NavRoutes.chooseJobTypeScreen

fun NavController.navigateToChooseJobType(navOptions: NavOptions? = null) {
    this.navigate(chooseJobTypeNavigation, navOptions)
}

fun NavGraphBuilder.chooseJobTypeScreen(navController: NavHostController) {
    composable(route = chooseJobTypeNavigation) {
        ChooseJobTypeRoute(
            onContinueClick = { navController.navigateToExpertiseScreen() }
        )
    }
}
