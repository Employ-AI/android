package com.client.feature.account.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.client.common.COUNTRY
import com.client.common.INTEREST
import com.client.common.JOB_TYPE
import com.client.common.NavRoutes
import com.client.common.UID
import com.client.feature.account.ExpertiseRoute

const val expertiseScreenNavigationRoute = NavRoutes.EXPERTISE_ROUTE

fun NavController.navigateToExpertiseScreen(navOptions: NavOptions? = null) {
    this.navigate(expertiseScreenNavigationRoute, navOptions)
}

fun NavGraphBuilder.expertiseScreen(navController: NavHostController) {
    composable(
        route = "${NavRoutes.EXPERTISE_ROUTE}/{$UID}/{$COUNTRY}/{$JOB_TYPE}/{$INTEREST}",
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
            },
            navArgument(INTEREST) {
                defaultValue = ""
                nullable = false
            }
        )
    ) { backStackEntry ->
        val uid = backStackEntry.arguments?.getString(UID) ?: ""
        val selectedCountry = backStackEntry.arguments?.getString(COUNTRY) ?: ""
        val selectedJobType = backStackEntry.arguments?.getString(JOB_TYPE) ?: ""
        val selectedInterestType = backStackEntry.arguments?.getString(INTEREST) ?: ""

        ExpertiseRoute(
            onContinueClick = { selectedExpertise ->
                val route = "${NavRoutes.FILL_PROFILE_ROUTE}/$uid/$selectedCountry/$selectedJobType/" +
                    "$selectedInterestType/$selectedExpertise"
                navController.navigate(route)
            }
        )
    }
}
