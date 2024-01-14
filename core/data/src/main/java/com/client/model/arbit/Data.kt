package com.client.model.arbit

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("company_name")
    val companyName: String,
    @SerialName("created_at")
    val createdAt: Int,
    @SerialName("description")
    val description: String,
    @SerialName("job_types")
    val jobTypes: List<String>,
    @SerialName("location")
    val location: String,
    @SerialName("remote")
    val remote: Boolean,
    @SerialName("slug")
    val slug: String,
    @SerialName("tags")
    val tags: List<String>,
    @SerialName("title")
    val title: String,
    @SerialName("url")
    val url: String
)
