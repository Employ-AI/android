package com.client.account.data

import android.content.Context
import com.client.model.JobSimilarity
import com.google.mediapipe.tasks.core.BaseOptions
import com.google.mediapipe.tasks.core.Delegate
import com.google.mediapipe.tasks.text.textembedder.TextEmbedder
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.suspendCancellableCoroutine
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class MediaPipeEmbeddingsImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : MediaPipeEmbeddings {

    private lateinit var textEmbedder: TextEmbedder

    override suspend fun setUpMLModel() {
        suspendCancellableCoroutine { continuation ->
            try {
                val baseOptions = BaseOptions
                    .builder()
                    .setModelAssetPath(MODEL_NAME)
                    .setDelegate(Delegate.CPU)
                    .build()
                val optionsBuilder =
                    TextEmbedder.TextEmbedderOptions.builder().setBaseOptions(baseOptions)
                val options = optionsBuilder.build()
                textEmbedder = TextEmbedder.createFromOptions(context, options)
                continuation.resume(true)
            } catch (e: Exception) {
                continuation.resumeWithException(e)
            }
        }
    }

    override suspend fun getSimilarities(
        mainSentence: String,
        sentences: List<String>
    ): List<JobSimilarity> {
        return suspendCancellableCoroutine { continuation ->
            try {
                textEmbedder.let {
                    Timber.i("TextEmbeddingsViewModel", "Main Sentence => $mainSentence")
                    val mainSentenceEmbed = getEmbeddings(mainSentence)

                    val similaritySentences: MutableList<JobSimilarity> =
                        ArrayList<JobSimilarity>().apply {
                            sentences.forEach {
                                val sentenceEmbed = getEmbeddings(it)
                                val similarity =
                                    TextEmbedder.cosineSimilarity(mainSentenceEmbed, sentenceEmbed)

                                Timber.i(
                                    "TextEmbeddingsViewModel",
                                    "Embeddings Main Sentence => $mainSentence"
                                )

                                Timber.i(
                                    "TextEmbeddingsViewModel",
                                    "Embeddings Another Sentence => $sentenceEmbed"
                                )
                                if (similarity > MIN_SIMILARITY_VALUE) {
                                    this.add(
                                        JobSimilarity(
                                            mainSentence = mainSentence,
                                            sentence = it,
                                            mainSentenceEmbeddings = mainSentenceEmbed.toString(),
                                            sentenceEmbeddings = sentenceEmbed.toString(),
                                            resultSimilarity = similarity
                                        )
                                    )
                                }
                            }
                        }

                    similaritySentences.sortByDescending { it.resultSimilarity }
                    continuation.resume(similaritySentences)
                }
            } catch (e: Exception) {
                continuation.resumeWithException(e)
            }
        }
    }

    private fun getEmbeddings(sentence: String) = textEmbedder
        .embed(sentence)
        .embeddingResult()
        .embeddings()
        .first()

    private companion object {
        const val MODEL_NAME = "universal_sentence_encoder.tflite"
        const val MIN_SIMILARITY_VALUE = 0.8
    }
}
