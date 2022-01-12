package com.chestnut.mypractice.ui.main

import com.chestnut.mypractice.data.Article

data class NewsUiState(
    val isSignedIn: Boolean = false,
    val isPremium: Boolean = false,
    val newsItems: List<Article> = listOf(),
    val userMessages: List<String> = listOf()
)