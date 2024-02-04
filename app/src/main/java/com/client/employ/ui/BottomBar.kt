package com.client.employ.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import com.client.common.NavRoutes
import com.client.designSystem.component.NavigationBarItem
import com.client.designSystem.theme.colors.EmployColors
import com.client.employ.ui.navigation.TabsDestinations

@Composable
internal fun BottomBar(
    modifier: Modifier = Modifier,
    destinations: List<TabsDestinations>,
    onNavigateToDestination: (TabsDestinations) -> Unit,
    currentDestination: NavDestination?
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        tonalElevation = 0.dp
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            NavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    Icon(
                        imageVector = destination.unselectedIcon,
                        contentDescription = null,
                        tint = EmployColors.Gray
                    )
                },
                selectedIcon = {
                    Icon(
                        imageVector = destination.selectedIcon,
                        contentDescription = null,
                    )
                },
                label = {
                    if (selected) {
                        Text(
                            stringResource(destination.iconTextId),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                alwaysShowLabel = true
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF673AB7)
@Composable
private fun BottomBarPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        BottomBar(
            destinations = TabsDestinations.entries,
            onNavigateToDestination = {},
            currentDestination = NavDestination(NavRoutes.DASHBOARD_ROUTE)
        )
    }
}
