package com.client.feature.matching.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.client.designSystem.theme.colors.EmployColors
import com.client.employ.feature.matching.R

@Composable
internal fun BottomStartButton(
    isStartMatchingButtonEnabled: MutableState<Boolean>,
    onStartMatchingClick: () -> Unit
) {
    val shouldShowButton = remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        if (shouldShowButton.value) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                onClick = {
                    isStartMatchingButtonEnabled.value = false
                    shouldShowButton.value = false
                    onStartMatchingClick()
                }
            ) {
                Text(
                    text = stringResource(R.string.feature_matching_start_matching),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                onClick = {
                    isStartMatchingButtonEnabled.value = false
                    shouldShowButton.value = false
                    onStartMatchingClick()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = EmployColors.LightGray
                )
            ) {
                Text(
                    text = "Maybe later",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
