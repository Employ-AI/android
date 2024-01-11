package com.client.feature.account

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.feature.account.components.DateOfBirthInput
import com.client.feature.account.components.FullNameInput
import com.client.feature.account.components.GenderDropDown
import com.client.feature.account.components.NickNameInput
import com.client.feature.account.components.PhoneInput
import com.client.feature.account.components.ProfileEmailInput
import com.client.feature.account.components.ProfilePhotoBox

@Composable
fun FillProfileRoute(
    onContinueClick: () -> Unit
) {
    FillProfileScreen(
        onContinueClick = onContinueClick
    )
}

@Composable
internal fun FillProfileScreen(
    modifier: Modifier = Modifier,
    onContinueClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            ProfilePhotoBox()

            Spacer(modifier = Modifier.height(24.dp))

            FullNameInput()

            NickNameInput()

            DateOfBirthInput()

            ProfileEmailInput()

            PhoneInput()

            GenderDropDown()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                onClick = onContinueClick
            ) {
                Text(
                    text = stringResource(com.client.employ.core.ui.R.string.core_ui_continue),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true, apiLevel = 33)
@Composable
private fun FillProfileScreenPreview() {
    FillProfileScreen(
        onContinueClick = { /*TODO*/ }
    )
}
