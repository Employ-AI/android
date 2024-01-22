package com.client.auth.forgot

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.client.auth.components.EmailTextField
import com.client.employ.feature.auth.R
import com.client.ui.AuthBaseScreen

@Composable
fun ForgotPassRoute(
    forgotPassViewModel: ForgotPassViewModel = hiltViewModel(),
) {
    ForgotPass()
}

@Composable
internal fun ForgotPass(
    modifier: Modifier = Modifier
) {
    AuthBaseScreen(
        pageTitle = R.string.feature_auth_forgot_password
    ) {
        Spacer(modifier = modifier.height(25.dp))

        EmailTextField(onEmailChanged = { /*TODO*/ })

        Spacer(modifier = modifier.height(10.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            onClick = { /*TODO*/ }
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = stringResource(R.string.feature_auth_send_recovery_email),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ForgotPassScreenPreview() {
    ForgotPass()
}
