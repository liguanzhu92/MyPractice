package com.chestnut.mypractice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chestnut.mypractice.PracticeApplication.Companion.applicationScope
import com.chestnut.mypractice.api.NewsApiImpl
import com.chestnut.mypractice.data.ArticleRemoteSource
import com.chestnut.mypractice.data.ArticleRepository
import com.chestnut.mypractice.ui.main.MainViewModel
import kotlinx.coroutines.Dispatchers

@Suppress("UNCHECKED_CAST")
class ViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ) = with(modelClass) {
        when {
            isAssignableFrom(MainViewModel::class.java) ->
                MainViewModel(ArticleRepository(ArticleRemoteSource(NewsApiImpl(), Dispatchers.Default), applicationScope))
            else ->
                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}