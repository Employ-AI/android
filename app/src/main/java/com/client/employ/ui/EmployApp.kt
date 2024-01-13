package com.client.employ.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
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
    appState: AppState = navigationAppState()
) {
    val currentDestination = appState.currentDestination
    val destination = appState.currentTopLevelDestination
    val isAiMatchingRoute = NavRoutes.aiMatchingRoute == currentDestination?.route
    val isFirstLogin = true

    Scaffold(
        containerColor = Color.White,
        topBar = {
            if (!isAiMatchingRoute) {
                AppTopBar(
                    isFirstLogin = isFirstLogin,
                    navController = appState.navController,
                    currentDestination = appState.currentDestination,
                    name = "Mohsen Rzna",
                    notificationCount = 1
                )
            }
        },
        bottomBar = {
            if (!isFirstLogin) {
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
        Column(modifier = Modifier.fillMaxSize()) {
            AppNavigation(
                navController = appState.navController,
                padding = paddingValues
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun AppNavigation(
    navController: NavHostController,
    padding: PaddingValues
) {
    AppNavHost(
        navController = navController,
        modifier = Modifier
            .padding(padding)
            .consumeWindowInsets(padding)
    )
}

fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TabsDestinations) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
