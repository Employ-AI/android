package com.client.account.ui

import androidx.compose.runtime.Stable

@Stable
data class UserProfile(
    val fullName: String,
    val nickName: String,
    val dateOfBirth: String,
    val email: String,
    val phone: String,
    val gender: String
)
