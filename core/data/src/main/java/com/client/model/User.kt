package com.client.model

data class User(
    val id: String = "",
    val isAnonymous: Boolean = false,
    val name: String? = null,
    val fullName: String? = null,
    val nickName: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val bio: String? = null,
    val profilePicture: String? = null,
    val country: String? = null,
    val expertise: String? = null,
    val jobType: String? = null,
    val interests: String? = null,
    val dateOfBirth: String? = null,
    val gender: String? = null
)
