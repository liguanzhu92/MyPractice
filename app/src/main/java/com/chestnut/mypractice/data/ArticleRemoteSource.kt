package com.chestnut.mypractice.data

import com.chestnut.mypractice.api.NewsApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ArticleRemoteSource(private val newsApi: NewsApi, private val ioDispatcher: CoroutineDispatcher) {
    /**
     * Fetches the latest news from the network and returns the result.
     * This executes on an IO-optimized thread pool, the function is main-safe.
     */
    suspend fun fetchLatestNews(): ArticleData =
        // Move the execution to an IO-optimized thread since the ApiService
        // doesn't support coroutines and makes synchronous requests.
        withContext(ioDispatcher) {
            newsApi.fetchLatestNews()
        }

    fun getSecond() {
        newsApi.fetchNews()
    }

}