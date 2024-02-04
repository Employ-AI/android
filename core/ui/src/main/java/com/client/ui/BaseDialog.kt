package com.client.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.employ.core.ui.R

@Composable
fun BaseErrorDialog(
    modifier: Modifier = Modifier,
    title: String,
    message: String,
    shouldShowDismiss: Boolean = false
) {
    val shouldShowDialog = remember { mutableStateOf(true) }
    if (shouldShowDialog.value) {
        AlertDialog(
            modifier = modifier,
            icon = {
                Icon(
                    modifier = Modifier.size(48.dp),
                    imageVector = Icons.Default.Error,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error
                )
            },
            title = {
                Text(text = title)
            },
            text = {
                Text(text = message)
            },
            onDismissRequest = {
                shouldShowDialog.value = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        shouldShowDialog.value = false
                    }
                ) {
                    Text(text = stringResource(R.string.core_ui_ok))
                }
            },
            dismissButton = {
                if (shouldShowDismiss) {
                    TextButton(
                        onClick = {
                            shouldShowDialog.value = false
                        }
                    ) {
                        Text(text = "Dismiss")
                    }
                }
            }
        )
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
            message = "Please enter valid email and password!"
        )
    }
}
