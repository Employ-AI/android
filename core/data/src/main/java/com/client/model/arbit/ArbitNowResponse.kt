package com.client.model.arbit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArbitNowResponse(
    @SerialName("data")
    val `data`: List<Data>,
    @SerialName("links")
    val links: Links,
    @SerialName("meta")
    val meta: Meta
)
