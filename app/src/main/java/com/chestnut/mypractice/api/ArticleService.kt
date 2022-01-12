package com.chestnut.mypractice.api

import com.chestnut.mypractice.data.ArticleData
import retrofit2.Call
import retrofit2.http.*

interface ArticleService {

    @GET("/v1/covid")
    suspend fun searchNews(
        @Query("q") query: String,
        @Query("lang") lang: String
    ): ArticleData


    @GET("/v1/covid")
    fun searchSecondNews(
        @Query("q") query: String,
        @Query("lang") lang: String
    ): Call<ArticleData>
}