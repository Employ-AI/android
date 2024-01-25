package com.client.model

data class User(
    val id: String = "",
    val isAnonymous: Boolean = true,
    val name: String? = null,
    val surname: String? = null,
    val nickName: String? = null,
    val email: String? = null,
    val password: String? = null,
    val phoneNumber: String? = null,
    val bio: String? = null,
    val profilePicture: String? = null,
    val country: String? = null,
    val expertise: String? = null,
    val interests: String? = null,
    val languages: String? = null,
    val birthDate: String? = null,
    val gender: String? = null
)
