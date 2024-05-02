package com.client.account.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.client.designSystem.theme.EmployM3Theme
import com.client.employ.feature.account.ui.R
import com.client.reusablecomponents.previews.AppComponent
import com.client.reusablecomponents.previews.MultiThemePreviews

@Composable
internal fun ProfileEmailInput(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    val email = remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val containerColor = colorResource(R.color.feature_account_text_field_search_background)
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = email.value,
        onValueChange = {
            email.value = it
            onValueChange(it)
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
            disabledContainerColor = containerColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(25.dp),
        placeholder = {
            Text(text = stringResource(R.string.feature_account_email))
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
        singleLine = true,
        maxLines = 1
    )
}

@MultiThemePreviews
@Composable
private fun ProfileEmailInputPreview() {
    AppComponent {
        EmployM3Theme(dark = false) {
            ProfileEmailInput(onValueChange = {})
        }
    }
}
