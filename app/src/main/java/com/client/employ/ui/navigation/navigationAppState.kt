package com.client.employ.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.util.trace
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.client.feature.dashboard.navigation.dashboardNavigationRoute
import com.client.feature.dashboard.navigation.navigateToDashboard

@Composable
internal fun navigationAppState(
    navController: NavHostController = rememberNavController()
): AppState {
    return remember(navController) {
        AppState(navController)
    }
}

@Stable
internal class AppState(
    val navController: NavHostController
) {

    val topLevelDestinations: List<TabsDestinations> = TabsDestinations.entries

    val currentTopLevelDestination: TabsDestinations?
        @Composable get() = when (currentDestination?.route) {
            dashboardNavigationRoute -> TabsDestinations.Dashboard
            else -> null
        }

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    fun navigateToSpecificDestination(topLevelDestination: TabsDestinations) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }

            when (topLevelDestination) {
                TabsDestinations.Dashboard -> navController.navigateToDashboard(topLevelNavOptions)
                TabsDestinations.MESSAGE -> navController.navigateToDashboard(topLevelNavOptions)
                TabsDestinations.APPLICATIONS -> navController.navigateToDashboard(
                    topLevelNavOptions
                )

                TabsDestinations.PROFILE -> navController.navigateToDashboard(topLevelNavOptions)
                TabsDestinations.SAVED_JOBS -> navController.navigateToDashboard(topLevelNavOptions)
            }
        }
    }
}
