package com.client.model

data class JobSimilarity(
    val mainSentence: String,
    val sentence: String,
    val mainSentenceEmbeddings: String,
    val sentenceEmbeddings: String,
    val resultSimilarity: Double,
)
