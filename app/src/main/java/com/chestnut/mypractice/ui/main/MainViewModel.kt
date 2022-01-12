package com.chestnut.mypractice.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chestnut.mypractice.data.Article
import com.chestnut.mypractice.data.ArticleRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel(private val articleRepository: ArticleRepository) : ViewModel() {
    private var fetchJob: Job? = null
    val newsLivedata : MutableLiveData<List<Article>> = MutableLiveData()

    fun fetchNews() {
        //articleRepository.getSecond()
        viewModelScope.launch {
            try {
                val newsItems = articleRepository.getLatestNews(true)
                newsLivedata.postValue(newsItems)
            } catch (e: Exception) {
                Log.i("test", "error")
            }
        }
    }
}