package com.client.di

import com.client.network.NetworkDataSource
import com.client.network.RetrofitEmployNetwork
import com.client.network.firebase.FirebaseReadRepository
import com.client.network.firebase.FirebaseReadRepositoryImpl
import com.client.network.firebase.auth.FirebaseAuthRepository
import com.client.network.firebase.auth.FirebaseAuthRepositoryImpl
import com.client.sources.arbeitNow.ArbitNowRepository
import com.client.sources.arbeitNow.ArbitNowRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

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
        firebaseWriteRepositoryImpl: FirebaseAuthRepositoryImpl
    ): FirebaseAuthRepository

    @Binds
    fun bindFirebaseReadRepository(
        firebaseReadRepositoryImpl: FirebaseReadRepositoryImpl
    ): FirebaseReadRepository
}
