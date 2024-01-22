package com.client.network.service

import com.client.employ.core.data.BuildConfig
import com.client.model.arbit.ArbitNowResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

private const val BASE_URL = BuildConfig.BACKEND_URL

@Serializable
data class NetworkResponse<T>(
    val data: T
)

@Singleton
class RetrofitEmployNetwork @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: Call.Factory
) : NetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .build()
        .create(RetrofitNetworkApi::class.java)

    override suspend fun getArbitJobs(): ArbitNowResponse {
        return networkApi.getJobs().data
    }
}
