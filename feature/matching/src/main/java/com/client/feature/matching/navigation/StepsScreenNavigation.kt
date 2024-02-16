package com.client.feature.matching.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.client.common.NavRoutes
import com.client.feature.matching.StepsRoute

const val stepsScreenNavigationRoute = NavRoutes.STEPS_ROUTE

fun NavController.navigateToStepsScreen(navOptions: NavOptions? = null) {
    this.navigate(stepsScreenNavigationRoute, navOptions)
}

fun NavGraphBuilder.stepsScreen(navController: NavHostController) {
    composable(route = stepsScreenNavigationRoute) {
        StepsRoute(navController)
    }
}
