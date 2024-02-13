package com.client.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.employ.core.ui.R

@Composable
fun SignInWithIcons(
    onGoogleSignInClick: () -> Unit,
    onAppleSignInClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier.padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CircularIconButton(
                icon = painterResource(id = R.drawable.google_icon),
                onClick = onGoogleSignInClick
            )
            CircularIconButton(
                icon = painterResource(id = R.drawable.apple_icon),
                onClick = onAppleSignInClick
            )
        }
    }
}

@Composable
private fun CircularIconButton(
    icon: Painter,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.size(width = 86.dp, height = 50.dp),
        border = BorderStroke(
            1.dp,
            color = colorResource(R.color.core_ui_border_color)
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = Color.Unspecified
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = icon,
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun SignInWithIconsPreview() {
    Column(
        modifier = Modifier.size(250.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SignInWithIcons(
            onGoogleSignInClick = {},
            onAppleSignInClick = {}
        )
    }
}
