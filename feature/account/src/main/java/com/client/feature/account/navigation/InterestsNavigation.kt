package com.client.feature.account.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.client.common.NavRoutes
import com.client.feature.account.InterestsRoute

const val InterestsScreenNavigationRoute = NavRoutes.INTERESTS_ROUTE

fun NavController.navigateToInterestsScreen(navOptions: NavOptions? = null) {
    this.navigate(InterestsScreenNavigationRoute, navOptions)
}

fun NavGraphBuilder.interestsScreen(navController: NavHostController) {
    composable(
        route = NavRoutes.INTERESTS_ROUTE,
    ) { backStackEntry ->
        InterestsRoute(
            onInterestClick = { interests ->
                // TODO: do sth with interests
            }
        )
    }
}
