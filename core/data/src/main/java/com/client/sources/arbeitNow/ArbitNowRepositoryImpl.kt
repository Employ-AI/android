package com.client.sources.arbeitNow

import com.client.Dispatcher
import com.client.EmployDispatchers.IO
import com.client.model.arbit.Data
import com.client.network.service.NetworkDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ArbitNowRepositoryImpl @Inject constructor(
    private val network: NetworkDataSource,
    @Dispatcher(IO) private val ioDispatcher: CoroutineDispatcher
) : ArbitNowRepository {

    override fun getJobs(): Flow<List<Data>> = flow {
        val getJobs = network.getArbitJobs().data
        emit(getJobs)
    }.flowOn(ioDispatcher)
}
