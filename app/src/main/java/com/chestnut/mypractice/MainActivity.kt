package com.chestnut.mypractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chestnut.mypractice.data.ArticleData
import com.chestnut.mypractice.ui.main.MainFragment
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        //loadArticlesFromNetwork()
    }

    private fun loadArticlesFromNetwork() {
        val jsonArticles = assets.open("article.json").readBytes().toString(Charsets.UTF_8)
        val articles = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create()
            .fromJson(jsonArticles, ArticleData::class.java).articles
        print(articles)
    }
}