package com.chestnut.mypractice.api

import com.chestnut.mypractice.data.ArticleData

interface NewsApi {
    suspend fun fetchLatestNews(q:String = "covid", lang:String = "en"):ArticleData
    fun fetchNews(q:String = "covid", lang:String = "en")
}