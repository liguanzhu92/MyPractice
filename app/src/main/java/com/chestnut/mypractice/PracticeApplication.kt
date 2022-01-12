package com.chestnut.mypractice

import android.app.Application
import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class PracticeApplication:Application() {
    companion object {
        var application: Application? = null
            private set

        val context: Context
            get() = application!!.applicationContext

        val applicationScope = CoroutineScope(SupervisorJob())
    }
    override fun onCreate() {
        super.onCreate()
        application = this
    }
}