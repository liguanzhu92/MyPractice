package com.chestnut.mypractice.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor


object RetrofitFactory {
    private const val BASE_URL = "https://covid-19-news.p.rapidapi.com"
    private lateinit var retrofit:Retrofit
    //private val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()

    fun <T> buildService(service: Class<T>) : T {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        clientBuilder.addInterceptor(HeaderInterceptor())
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(clientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build().create(service)
    }
}