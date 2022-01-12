package com.chestnut.mypractice.util

import androidx.fragment.app.Fragment
import com.chestnut.mypractice.ViewModelFactory

fun Fragment.getViewModelFactory(): ViewModelFactory {
    return ViewModelFactory()
}