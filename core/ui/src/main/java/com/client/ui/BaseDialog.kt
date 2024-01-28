package com.client.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.client.employ.core.ui.R

@Composable
fun BaseErrorDialog(
    modifier: Modifier = Modifier,
    title: String,
    message: String
) {
    val shouldShowDialog = remember { mutableStateOf(true) }
    if (shouldShowDialog.value) {
        Dialog(
            onDismissRequest = {
                shouldShowDialog.value = false
            }
        ) {
            Card(
                modifier = Modifier.padding(16.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Column(
                    modifier
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = message,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    ElevatedButton(
                        onClick = { shouldShowDialog.value = false }
                    ) {
                        Text(text = stringResource(R.string.core_ui_ok))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BaseErrorDialogPreview() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        BaseErrorDialog(
            title = "Error",
            message = "Error message"
        )
    }
}
