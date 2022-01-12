package com.chestnut.mypractice.api

import android.util.Log
import com.chestnut.mypractice.data.ArticleData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsApiImpl:NewsApi {
    override suspend fun fetchLatestNews(q: String, lang: String): ArticleData {
        val service = RetrofitFactory.buildService(ArticleService::class.java)
        return service.searchNews(q, lang)
    }

    override fun fetchNews(q: String, lang: String) {
        val service = RetrofitFactory.buildService(ArticleService::class.java)
        val call = service.searchSecondNews(q,lang)
        call.enqueue(object : Callback<ArticleData> {
            override fun onResponse(call: Call<ArticleData>, response: Response<ArticleData>) {
                Log.i("test", response.message())
            }

            override fun onFailure(call: Call<ArticleData>, t: Throwable) {
                Log.i("test", "error fetch")
            }

        })
    }
}