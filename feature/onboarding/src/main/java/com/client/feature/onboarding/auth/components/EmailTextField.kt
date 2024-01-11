package com.client.feature.onboarding.auth.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.employ.feature.onboarding.R

@Composable
internal fun EmailTextField(
    modifier: Modifier = Modifier
) {
    val email = rememberSaveable { mutableStateOf("") }
    val containerColor = colorResource(R.color.feature_onboarding_text_field_background)

    TextField(
        modifier = modifier.fillMaxWidth(),
        value = email.value,
        onValueChange = {
            email.value = it
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
            disabledContainerColor = containerColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(25.dp),
        leadingIcon = {
            Icon(
                modifier = modifier.padding(start = 16.dp),
                imageVector = Icons.Outlined.Email,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        },
        placeholder = {
            Text(text = stringResource(R.string.feature_onboarding_email))
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun EmailTextFieldPreview() {
    EmailTextField()
}