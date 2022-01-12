package com.chestnut.mypractice.data

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("_id")
    val id: String,
    @SerializedName("_score")
    val score:Float,
    val author:String?,
    @SerializedName("clean_url")
    val cleanURL: String,
    val country: String,
    val language: String,
    val link:String,
    @SerializedName("published_date")
    val publishDate: String,
    val rank:Int,
    val rights:String,
    val summary: String,
    val title: String,
    val topic: String,
    @SerializedName("media_content")
    val media:List<String>
)

data class ArticleData(val articles: List<Article>)
