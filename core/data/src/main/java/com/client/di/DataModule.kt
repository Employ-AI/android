package com.client.di

import com.client.network.firebase.auth.AccountService
import com.client.network.firebase.auth.AccountServiceImpl
import com.client.network.firebase.auth.FireStoreRepository
import com.client.network.firebase.auth.FireStoreRepositoryImpl
import com.client.network.service.NetworkDataSource
import com.client.network.service.RetrofitEmployNetwork
import com.client.sources.arbeitNow.ArbitNowRepository
import com.client.sources.arbeitNow.ArbitNowRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindArbitNowRepository(
        arbitNowRepositoryImpl: ArbitNowRepositoryImpl
    ): ArbitNowRepository

    @Binds
    fun bindNetworkDataSource(
        retrofitEmployNetwork: RetrofitEmployNetwork
    ): NetworkDataSource

    @Binds
    fun bindFirebaseWriteRepository(
        firebaseWriteRepositoryImpl: FireStoreRepositoryImpl
    ): FireStoreRepository

    @Binds
    fun bindsAccountService(
        accountServiceImpl: AccountServiceImpl
    ): AccountService
}
