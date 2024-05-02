package com.client.auth.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.common.ui.validateEmail
import com.client.employ.feature.auth.ui.R

@Composable
internal fun EmailTextField(
    modifier: Modifier = Modifier,
    isEmailValid: (Boolean) -> Unit,
    onEmailChanged: (String) -> Unit
) {
    val email = rememberSaveable { mutableStateOf("") }
    val containerColor = colorResource(R.color.feature_auth_text_field_background)
    val focusManager = LocalFocusManager.current

    TextField(
        modifier = modifier.fillMaxWidth(),
        value = email.value,
        onValueChange = {
            email.value = it
            if (it.validateEmail()) {
                onEmailChanged(it)
                isEmailValid(true)
            } else {
                onEmailChanged("")
                isEmailValid(false)
            }
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
            disabledContainerColor = containerColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(25.dp),
        maxLines = 1,
        leadingIcon = {
            Icon(
                modifier = modifier.padding(start = 16.dp),
                imageVector = Icons.Outlined.Email,
                contentDescription = null,
                tint = Color.Gray
            )
        },
        placeholder = {
            Text(text = stringResource(R.string.feature_auth_email))
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun EmailTextFieldPreview() {
    EmailTextField(
        isEmailValid = {},
        onEmailChanged = {},
    )
}
