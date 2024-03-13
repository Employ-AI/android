package com.client.feature.matching.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.employ.feature.matching.R
import com.client.ui.components.PrimaryButton
import com.client.ui.components.SecondaryButton

@Composable
internal fun BottomButton(
    isMatchingEnabled: MutableState<Boolean>,
    onStartMatchingClick: () -> Unit,
    onCancelClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        if (isMatchingEnabled.value) {
            SecondaryButton(
                text = R.string.feature_matching_cancel,
                onClick = onCancelClick
            )
        } else {
            PrimaryButton(
                text = R.string.feature_matching_start_matching,
                onClick = onStartMatchingClick
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
private fun BottomStartButtonPreview() {
    val isStartMatchingButtonEnabled = remember { mutableStateOf(true) }
    BottomButton(
        isMatchingEnabled = isStartMatchingButtonEnabled,
        onStartMatchingClick = {},
        onCancelClick = {}
    )
}
