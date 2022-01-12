package com.chestnut.mypractice.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class ArticleRepository(
    private val remoteSource: ArticleRemoteSource,
    private val externalScope: CoroutineScope
) {
    // Mutex to make writes to cached values thread-safe.
    private val latestNewsMutex = Mutex()

    // Cache of the latest news got from the network.
    private var latestNews: List<Article> = emptyList()

    suspend fun getLatestNews(refresh: Boolean = false): List<Article> {
        return if (refresh) {
            externalScope.async {
                remoteSource.fetchLatestNews().articles.also {
                    latestNewsMutex.withLock {
                        latestNews = it
                    }
                }

            }.await()
        } else {
            return latestNewsMutex.withLock { this.latestNews }
        }
    }
}