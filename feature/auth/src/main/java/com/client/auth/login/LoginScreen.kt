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
import com.client.auth.components.RememberMeCheckBox
import com.client.auth.components.TextWithHorizontalLines
import com.client.employ.feature.auth.R
import com.client.ui.AuthBaseScreen
import com.client.ui.BaseErrorDialog
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
        onDontHaveAnAccountClick = onNotHaveAnAccountClick,
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
    onDontHaveAnAccountClick: () -> Unit,
    onForgotPassClick: () -> Unit,
    onSignInClick: (String, String) -> Unit,
    onLoginSuccess: (String) -> Unit
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    AuthBaseScreen(pageTitle = R.string.feature_auth_login_to_your_account) {
        Spacer(modifier = modifier.height(25.dp))

        EmailTextField(
            onEmailChanged = {
                email.value = it
            }
        )

        Spacer(modifier = modifier.height(10.dp))

        PasswordTextField(
            onPasswordChanged = {
                password.value = it
            }
        )

        RememberMeCheckBox()

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            onClick = {
                if (email.value.isNotEmpty() && password.value.isNotEmpty()) {
                    onSignInClick(email.value, password.value)
                } else {
                    println("LoginScreen: Email or password is empty!")
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

        TextButton(onClick = onDontHaveAnAccountClick) {
            Text(
                text = stringResource(R.string.feature_auth_don_t_have_an_account),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }

    when (authState) {
        is LoginState.Loading -> {
            // TODO: Add loading indicator
        }

        is LoginState.Success -> {
            val uid = authState.uid
            LaunchedEffect(key1 = uid) {
                onLoginSuccess(uid)
            }
        }

        is LoginState.Error -> OnError(authState.message)
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
    LoginScreen(
        onGoogleSignInClick = {},
        onAppleSignInClick = {},
        onDontHaveAnAccountClick = {},
        onForgotPassClick = {},
        onSignInClick = { _, _ -> },
        authState = LoginState.Loading,
        onLoginSuccess = {}
    )
}
