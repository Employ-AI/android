package com.client.network.service

import com.client.model.arbit.ArbitNowResponse

interface NetworkDataSource {
    suspend fun getArbitJobs(): ArbitNowResponse
}
