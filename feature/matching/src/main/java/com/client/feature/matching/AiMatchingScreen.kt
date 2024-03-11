package com.client.feature.matching

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.client.employ.feature.matching.R
import com.client.feature.matching.components.BottomButton
import com.client.feature.matching.components.HiddenComponents
import com.client.feature.matching.components.VisibleComponents

@Composable
fun AiMatchingRoute(
    aiMatchingViewModel: AiMatchingViewModel = hiltViewModel(),
) {
    AiMatchingScreen(
        onStartMatchingClick = {}
    )
}

@Composable
internal fun AiMatchingScreen(
    modifier: Modifier = Modifier,
    onStartMatchingClick: () -> Unit
) {
    val isMatchingEnabled = remember { mutableStateOf(false) }
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.ai_animation)
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = if (isMatchingEnabled.value) LottieConstants.IterateForever else 1
    )

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottieAnimation(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(if (isMatchingEnabled.value) 300.dp else 250.dp),
                composition = composition,
                progress = { progress }
            )

            AnimatedContent(
                targetState = isMatchingEnabled.value.not(),
                transitionSpec = {
                    fadeIn(
                        animationSpec = tween(durationMillis = 50)
                    ) togetherWith fadeOut(animationSpec = tween(durationMillis = 50))
                },
                label = ""
            ) {
                if (it) VisibleComponents()
            }

            AnimatedVisibility(
                visible = isMatchingEnabled.value,
                enter = fadeIn(initialAlpha = 0f),
                exit = fadeOut(animationSpec = tween(durationMillis = 50))
            ) {
                HiddenComponents()
            }
        }
    }

    BottomButton(
        isMatchingEnabled = isMatchingEnabled,
        onStartMatchingClick = {
            isMatchingEnabled.value = true
            // TODO: Start matching
        },
        onCancelClick = {
            isMatchingEnabled.value = false
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun AiMatchingPreview() {
    AiMatchingScreen(onStartMatchingClick = {})
}
