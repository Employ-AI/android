package com.client.employ.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.client.common.NavRoutes
import com.client.employ.R

@Composable
internal fun AppTopBar(
    isFirstLogin: Boolean,
    name: String,
    notificationCount: Int,
    navController: NavHostController,
    currentDestination: NavDestination?
) {
    when {
        isFirstLogin ->
            NotLoggedInUserToolbar(
                currentDestination = currentDestination,
                navController = navController
            )

        else -> LoggedInToolbar()
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun LoggedInToolbar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    AsyncImage(
                        modifier = Modifier.clip(CircleShape),
                        model = "https://avatars.githubusercontent.com/u/3139113?v=4",
                        placeholder = painterResource(R.drawable.baseline_person_24),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column(
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(
                        stringResource(R.string.good_morning),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        "Mohsen Rzna",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        },
        actions = {
            IconButton(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .border(1.dp, Color.LightGray, CircleShape),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        }
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun NotLoggedInUserToolbar(
    modifier: Modifier = Modifier,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val title = when (currentDestination?.route) {
        NavRoutes.COUNTRY_SELECTION_ROUTE -> "Select Country"
        else -> null
    }
    val isLandingRoute = currentDestination?.route == NavRoutes.LANDING_ROUTE
    val isLoginRoute = currentDestination?.route == NavRoutes.LOGIN_ROUTE

    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = title ?: "",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            if (isLandingRoute.not() && isLoginRoute.not()) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        }
    )
}

@Preview
@Composable
private fun AppTopBarNotLoggedInPreview() {
    NotLoggedInUserToolbar(
        currentDestination = null,
        navController = NavHostController(LocalContext.current)
    )
}

@Preview
@Composable
private fun AppTopBarLoggedInPreview() {
    LoggedInToolbar()
}
