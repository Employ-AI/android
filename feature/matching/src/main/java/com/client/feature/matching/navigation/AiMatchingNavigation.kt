package com.client.feature.matching.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.client.common.NavRoutes
import com.client.feature.matching.AiMatchingRoute

const val aiMatchingNavigationRoute = NavRoutes.aiMatchingRoute

fun NavController.navigateToAiMatchingScreen(navOptions: NavOptions? = null) {
    this.navigate(aiMatchingNavigationRoute, navOptions)
}

fun NavGraphBuilder.aiMatchingScreen(navController: NavHostController) {
    composable(route = aiMatchingNavigationRoute) {
        AiMatchingRoute()
    }
}
