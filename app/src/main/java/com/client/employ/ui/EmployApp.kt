package com.client.employ.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.client.common.NavRoutes
import com.client.employ.ui.navigation.AppNavHost
import com.client.employ.ui.navigation.AppState
import com.client.employ.ui.navigation.TabsDestinations
import com.client.employ.ui.navigation.navigationAppState

@Composable
internal fun EmployApp(
    appState: AppState = navigationAppState(),
    isFirstLogin: Boolean = false
) {
    val currentDestination = appState.currentDestination
    val destination = appState.currentTopLevelDestination
    val isLandingRoute = currentDestination?.route == NavRoutes.LANDING_ROUTE

    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            if (isFirstLogin && isLandingRoute.not()) {
                AppTopBar(
                    isFirstLogin = isFirstLogin,
                    name = "John Doe",
                    notificationCount = 0,
                    navController = appState.navController,
                    currentDestination = currentDestination,
                )
            }
        },
        bottomBar = {
            if (isFirstLogin.not()) {
                BottomBar(
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigateToSpecificDestination,
                    currentDestination = appState.currentDestination,
                    modifier = Modifier.testTag("BottomBar")
                )
            }
        },
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { paddingValues ->
        AppNavigation(
            navController = appState.navController,
            isFirstLogin = isFirstLogin,
            padding = paddingValues
        )
    }
}

@Composable
private fun AppNavigation(
    navController: NavHostController,
    padding: PaddingValues,
    isFirstLogin: Boolean
) {
    AppNavHost(
        navController = navController,
        isFirstLogin = isFirstLogin,
        modifier = Modifier
            .padding(padding)
            .consumeWindowInsets(padding)
    )
}

fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TabsDestinations) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
