package com.client.account.data.di

import com.client.account.data.MediaPipeEmbeddings
import com.client.account.data.MediaPipeEmbeddingsImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataMediaPipeModule {

    @Binds
    fun bindMediaPipeEmbeddings(
        mediaPipeEmbeddingsImpl: MediaPipeEmbeddingsImpl
    ): MediaPipeEmbeddings
}
