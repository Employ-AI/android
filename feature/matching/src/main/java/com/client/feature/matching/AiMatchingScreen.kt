package com.client.feature.matching

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Composable
fun AiMatchingRoute(
    navController: NavHostController
) {
    AiMatchingScreen()
}

@Composable
internal fun AiMatchingScreen(
    modifier: Modifier = Modifier,
) {
}

@Preview
@Composable
fun AiMatchingPreview() {
    AiMatchingScreen()
}
