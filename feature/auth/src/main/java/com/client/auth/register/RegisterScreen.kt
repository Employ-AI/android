package com.client.auth.register

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.client.auth.components.EmailTextField
import com.client.auth.components.PasswordTextField
import com.client.auth.components.TextWithHorizontalLines
import com.client.employ.feature.auth.R
import com.client.ui.AuthBaseScreen
import com.client.ui.BaseErrorDialog
import com.client.ui.SignInWithIcons

@Composable
fun RegisterRoute(
    registerViewModel: RegisterViewModel = hiltViewModel(),
    onAlreadyAccountExistClick: () -> Unit
) {
    val registerState = registerViewModel.registerState.collectAsStateWithLifecycle()
    RegisterScreen(
        authState = registerState.value,
        onGoogleSignInClick = {},
        onAppleSignInClick = {},
        onAlreadyAccountExistClick = onAlreadyAccountExistClick,
        onSignUpClick = registerViewModel::onSignUpClicked
    )
}

@Composable
internal fun RegisterScreen(
    modifier: Modifier = Modifier,
    authState: RegisterState,
    onGoogleSignInClick: () -> Unit,
    onAppleSignInClick: () -> Unit,
    onAlreadyAccountExistClick: () -> Unit,
    onSignUpClick: (String, String) -> Unit
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    AuthBaseScreen(pageTitle = R.string.feature_auth_create_new_account) {
        Spacer(modifier = modifier.height(25.dp))

        EmailTextField(onEmailChanged = { email.value = it })

        Spacer(modifier = modifier.height(10.dp))

        PasswordTextField(onPasswordChanged = { password.value = it })

        Spacer(modifier = modifier.height(16.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onSignUpClick(email.value, password.value) }
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = stringResource(R.string.feature_auth_sign_up),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = modifier.height(32.dp))

        TextWithHorizontalLines()

        SignInWithIcons(
            onGoogleSignInClick = onGoogleSignInClick,
            onAppleSignInClick = onAppleSignInClick
        )

        Spacer(modifier = modifier.height(36.dp))

        TextButton(onClick = onAlreadyAccountExistClick) {
            Text(
                text = stringResource(R.string.feature_auth_already_have_an_account),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }

    when (authState) {
        is RegisterState.Loading -> Unit
        is RegisterState.Success -> {
            val uid = authState.uid
            LaunchedEffect(key1 = uid) {
                // onRegisterSuccess(uid)
            }
        }

        is RegisterState.Error -> OnError(authState.message)
    }
}

@Composable
private fun OnError(message: String) {
    BaseErrorDialog(
        title = "Error",
        message = message
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun LoginScreenPreview() {
    RegisterScreen(
        authState = RegisterState.Loading,
        onGoogleSignInClick = {},
        onAppleSignInClick = {},
        onAlreadyAccountExistClick = {},
        onSignUpClick = { _, _ -> }
    )
}
