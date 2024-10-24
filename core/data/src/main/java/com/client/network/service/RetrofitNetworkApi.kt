package com.client.network.service

import com.client.model.arbit.ArbitNowResponse
import retrofit2.http.GET

internal interface RetrofitNetworkApi {

    @GET("job-board-api")
    suspend fun getJobs(): NetworkResponse<ArbitNowResponse>
}
