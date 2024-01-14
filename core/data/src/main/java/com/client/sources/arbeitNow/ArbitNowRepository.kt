package com.client.sources.arbeitNow

import com.client.model.arbit.Data
import kotlinx.coroutines.flow.Flow

interface ArbitNowRepository {
    fun getJobs(): Flow<List<Data>>
}
