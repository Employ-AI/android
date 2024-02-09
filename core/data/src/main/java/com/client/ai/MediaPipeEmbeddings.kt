package com.client.ai

import com.client.model.JobSimilarity

interface MediaPipeEmbeddings {

    suspend fun setUpMLModel()

    suspend fun getSimilarities(
        mainSentence: String,
        sentences: List<String>
    ): List<JobSimilarity>
}
