package com.client.model.arbit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    @SerialName("current_page")
    val currentPage: Int,
    @SerialName("from")
    val from: Int,
    @SerialName("info")
    val info: String,
    @SerialName("path")
    val path: String,
    @SerialName("per_page")
    val perPage: Int,
    @SerialName("terms")
    val terms: String,
    @SerialName("to")
    val to: Int
)
