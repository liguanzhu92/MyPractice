package com.chestnut.mypractice.api

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("x-rapidapi-host", "covid-19-news.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "b281ef5d2bmsh1b990920c88d915p191cacjsneba13736f23f")
            .build()
        return chain.proceed(request)
    }

}