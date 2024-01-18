package com.client.model.arbit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("first")
    val first: String,
    @SerialName("last")
    val last: String? = null,
    @SerialName("next")
    val next: String,
    @SerialName("prev")
    val prev: String? = null
)
