package com.client.account.ui

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.client.account.ui.components.DateTextField
import com.client.account.ui.components.FullNameInput
import com.client.account.ui.components.GenderDropDown
import com.client.account.ui.components.NickNameInput
import com.client.account.ui.components.PhoneInput
import com.client.account.ui.components.ProfileEmailInput
import com.client.account.ui.components.ProfilePhotoBox
import com.client.designSystem.theme.EmployM3Theme
import com.client.reusablecomponents.previews.AppScreenComponent
import com.client.reusablecomponents.previews.MultiThemePreviews

@Composable
fun FillProfileRoute(
    accountViewModel: AccountViewModel = hiltViewModel(),
    onProfileFilled: () -> Unit
) {
    val uiState = accountViewModel.uiState.collectAsStateWithLifecycle()
    FillProfileScreen(
        uiState = uiState.value,
        onUserProfileFilled = onProfileFilled,
        onContinueClick = accountViewModel::onProfileFilled
    )
}

@Composable
internal fun FillProfileScreen(
    modifier: Modifier = Modifier,
    uiState: AccountState,
    onUserProfileFilled: () -> Unit,
    onContinueClick: (UserProfile) -> Unit
) {
    val fullName = rememberSaveable { mutableStateOf("") }
    val nickName = rememberSaveable { mutableStateOf("") }
    val dateOfBirth = rememberSaveable { mutableStateOf("") }
    val email = rememberSaveable { mutableStateOf("") }
    val phone = rememberSaveable { mutableStateOf("") }
    val gender = rememberSaveable { mutableStateOf("male") }

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
            FullNameInput(onValueChange = { fullName.value = it })
            NickNameInput(onValueChange = { nickName.value = it })
            DateTextField(
                onValueChange = { dateOfBirth.value = it },
                value = dateOfBirth.value
            )
            ProfileEmailInput(onValueChange = { email.value = it })
            PhoneInput(onValueChange = { phone.value = it })
            GenderDropDown(onGenderSelected = { gender.value = it })
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
                onClick = {
                    onContinueClick(
                        UserProfile(
                            fullName = fullName.value,
                            nickName = nickName.value,
                            dateOfBirth = dateOfBirth.value,
                            email = email.value,
                            phone = phone.value,
                            gender = gender.value
                        )
                    )
                }
            ) {
                Text(
                    text = stringResource(com.client.employ.core.ui.R.string.core_ui_continue),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    when (uiState) {
        is AccountState.Loading -> Unit
        is AccountState.OnProfileFilled -> LaunchedEffect(uiState) {
            onUserProfileFilled()
        }

        else -> Unit
    }
}

@MultiThemePreviews
@Composable
private fun FillProfileScreenPreview() {
    AppScreenComponent {
        EmployM3Theme(dark = false) {
            FillProfileScreen(
                uiState = AccountState.Loading,
                onUserProfileFilled = { },
                onContinueClick = { }
            )
        }
    }
}
