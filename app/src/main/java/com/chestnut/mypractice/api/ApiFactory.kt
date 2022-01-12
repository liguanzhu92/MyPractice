package com.chestnut.mypractice.api

class ApiFactory {

    companion object {
        val instance: NewsApi by lazy { NewsApiImpl() }
    }

}