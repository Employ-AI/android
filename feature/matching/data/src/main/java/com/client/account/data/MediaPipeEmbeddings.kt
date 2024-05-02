package com.client.account.data

import com.client.model.JobSimilarity

interface MediaPipeEmbeddings {

    suspend fun setUpMLModel()

    suspend fun getSimilarities(
        mainSentence: String,
        sentences: List<String>
    ): List<JobSimilarity>
}
