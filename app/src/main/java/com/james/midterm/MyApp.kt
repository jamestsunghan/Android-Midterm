package com.james.midterm

import android.app.Application
import android.content.Context

class MyApp : Application(){

    override fun onCreate() {
        super.onCreate()
        MyApp.appContext = applicationContext
    }
    companion object{
        lateinit var appContext: Context
    }
}