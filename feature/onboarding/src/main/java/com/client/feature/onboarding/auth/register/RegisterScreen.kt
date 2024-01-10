package com.client.feature.onboarding.auth.register

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.client.employ.feature.onboarding.R
import com.client.feature.onboarding.auth.components.EmailTextField
import com.client.feature.onboarding.auth.components.PasswordTextField
import com.client.feature.onboarding.auth.components.RememberMeCheckBox
import com.client.feature.onboarding.auth.components.TextWithHorizontalLines
import com.client.ui.AuthBaseScreen
import com.client.ui.SignInWithIcons

@Composable
fun RegisterRoute(
    registerViewModel: RegisterViewModel = hiltViewModel(),
    onAlreadyAccountExistClick: () -> Unit
) {
    RegisterScreen(
        onGoogleSignInClick = {},
        onAppleSignInClick = {},
        onAlreadyAccountExistClick = onAlreadyAccountExistClick
    )
}

@Composable
internal fun RegisterScreen(
    modifier: Modifier = Modifier,
    onGoogleSignInClick: () -> Unit,
    onAppleSignInClick: () -> Unit,
    onAlreadyAccountExistClick: () -> Unit
) {
    AuthBaseScreen(pageTitle = R.string.feature_onboarding_create_new_account) {
        Spacer(modifier = modifier.height(25.dp))

        EmailTextField()

        Spacer(modifier = modifier.height(10.dp))

        PasswordTextField()

        RememberMeCheckBox()

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            onClick = { /*TODO*/ }
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = stringResource(R.string.feature_onboarding_sign_up),
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
                text = stringResource(R.string.feature_onboarding_already_have_an_account),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun LoginScreenPreview() {
    RegisterScreen(
        onGoogleSignInClick = {},
        onAppleSignInClick = {},
        onAlreadyAccountExistClick = {}
    )
}
