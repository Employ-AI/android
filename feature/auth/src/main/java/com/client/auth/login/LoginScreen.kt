package com.client.auth.login

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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.client.auth.components.EmailTextField
import com.client.auth.components.PasswordTextField
import com.client.auth.components.RememberMeCheckBox
import com.client.auth.components.TextWithHorizontalLines
import com.client.employ.feature.auth.R
import com.client.ui.AuthBaseScreen
import com.client.ui.BaseErrorDialog
import com.client.ui.CircularProgress
import com.client.ui.SignInWithIcons

@Composable
fun LoginRoute(
    loginViewModel: LoginViewModel = hiltViewModel(),
    onNotHaveAnAccountClick: () -> Unit,
    onForgotPassClick: () -> Unit,
    onLoginSuccess: (String) -> Unit
) {
    val authState = loginViewModel.authState.collectAsStateWithLifecycle()
    LoginScreen(
        authState = authState.value,
        onGoogleSignInClick = {},
        onAppleSignInClick = {},
        onNotHaveAnAccountClick = onNotHaveAnAccountClick,
        onForgotPassClick = onForgotPassClick,
        onSignInClick = loginViewModel::onLoginClick,
        onLoginSuccess = onLoginSuccess
    )
}

@Composable
internal fun LoginScreen(
    modifier: Modifier = Modifier,
    authState: LoginState,
    onGoogleSignInClick: () -> Unit,
    onAppleSignInClick: () -> Unit,
    onNotHaveAnAccountClick: () -> Unit,
    onForgotPassClick: () -> Unit,
    onSignInClick: (String, String) -> Unit,
    onLoginSuccess: (String) -> Unit
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val isEmailValid = remember { mutableStateOf(false) }
    val isPasswordValid = remember { mutableStateOf(false) }
    val shouldDisableSignInButton = remember { mutableStateOf(false) }
    val shouldShowErrorDialog = remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    AuthBaseScreen(pageTitle = R.string.feature_auth_login_to_your_account) {
        Spacer(modifier = modifier.height(25.dp))

        EmailTextField(
            isEmailValid = { isEmailValid.value = it },
            onEmailChanged = {
                email.value = it
            }
        )

        Spacer(modifier = modifier.height(10.dp))

        PasswordTextField(
            isPasswordValid = { isPasswordValid.value = it },
            onPasswordChanged = {
                password.value = it
            }
        )

        RememberMeCheckBox()

        SignInButton(
            shouldDisableSignInButton = shouldDisableSignInButton,
            keyboardController = keyboardController,
            isEmailValid = isEmailValid,
            isPasswordValid = isPasswordValid,
            onSignInClick = onSignInClick,
            email = email,
            password = password,
            shouldShowErrorDialog = shouldShowErrorDialog
        )

        Spacer(modifier = modifier.height(32.dp))

        TextButton(onClick = onForgotPassClick) {
            Text(
                text = stringResource(R.string.feature_auth_forgot_the_password),
                style = MaterialTheme.typography.bodyMedium,
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

        TextButton(onClick = onNotHaveAnAccountClick) {
            Text(
                text = stringResource(R.string.feature_auth_don_t_have_an_account),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }

    when (authState) {
        is LoginState.Initial -> Unit
        is LoginState.Loading -> CircularProgress()
        is LoginState.Success -> {
            val uid = authState.uid
            LaunchedEffect(key1 = uid) {
                onLoginSuccess(uid)
            }
        }

        is LoginState.Error -> OnError(authState.message)
    }

    if (email.value.isNotEmpty() && password.value.isNotEmpty()) {
        shouldDisableSignInButton.value = true
    }

    if (shouldShowErrorDialog.value) {
        ShowErrorDialog()
    }
}

@Composable
private fun SignInButton(
    shouldDisableSignInButton: MutableState<Boolean>,
    keyboardController: SoftwareKeyboardController?,
    isEmailValid: MutableState<Boolean>,
    isPasswordValid: MutableState<Boolean>,
    onSignInClick: (String, String) -> Unit,
    email: MutableState<String>,
    password: MutableState<String>,
    shouldShowErrorDialog: MutableState<Boolean>
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        enabled = shouldDisableSignInButton.value,
        onClick = {
            keyboardController?.hide()
            if (isEmailValid.value && isPasswordValid.value) {
                onSignInClick(email.value, password.value)
            } else {
                shouldShowErrorDialog.value = true
            }
        }
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(R.string.feature_auth_sign_in),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun ShowErrorDialog() {
    BaseErrorDialog(
        title = stringResource(R.string.feature_auth_error_dialog_title),
        message = stringResource(R.string.feature_auth_please_enter_valid_email_and_password_description)
    )
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
    LoginScreen(
        onGoogleSignInClick = {},
        onAppleSignInClick = {},
        onNotHaveAnAccountClick = {},
        onForgotPassClick = {},
        onSignInClick = { _, _ -> },
        authState = LoginState.Loading,
        onLoginSuccess = {}
    )
}
