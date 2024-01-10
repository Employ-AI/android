package com.client.feature.onboarding.auth.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.client.employ.feature.onboarding.R

@Composable
internal fun TextWithHorizontalLines(
    text: String = stringResource(R.string.feature_onboarding_or_continue_with)
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Divider(
            color = Color.LightGray,
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
        )
        Text(
            text = text,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Divider(
            color = Color.LightGray,
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
        )
    }
}