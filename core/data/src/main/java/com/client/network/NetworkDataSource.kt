package com.client.network

import com.client.model.arbit.ArbitNowResponse

interface NetworkDataSource {
    suspend fun getArbitJobs(): ArbitNowResponse
}
