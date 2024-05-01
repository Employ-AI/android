package com.client.account.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.client.account.ui.InterestsRoute
import com.client.common.COUNTRY
import com.client.common.JOB_TYPE
import com.client.common.NavRoutes
import com.client.common.UID

const val InterestsScreenNavigationRoute = NavRoutes.INTERESTS_ROUTE

fun NavController.navigateToInterestsScreen(navOptions: NavOptions? = null) {
    this.navigate(InterestsScreenNavigationRoute, navOptions)
}

fun NavGraphBuilder.interestsScreen(navController: NavHostController) {
    composable(
        route = "${NavRoutes.INTERESTS_ROUTE}/{$UID}/{$COUNTRY}/{$JOB_TYPE}",
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
            }
        )
    ) { backStackEntry ->
        val uid = backStackEntry.arguments?.getString(UID) ?: ""
        val selectedCountry = backStackEntry.arguments?.getString(COUNTRY) ?: ""
        val selectedJobType = backStackEntry.arguments?.getString(JOB_TYPE) ?: ""

        InterestsRoute(
            onInterestClick = { selectedInterest ->
                navController.navigate(
                    "${NavRoutes.EXPERTISE_ROUTE}/$uid/$selectedCountry/$selectedJobType/$selectedInterest"
                )
            }
        )
    }
}
