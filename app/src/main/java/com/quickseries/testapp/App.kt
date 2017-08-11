package com.quickseries.testapp

import android.app.Application

/**
 * Created by eddyhugues on 2017-08-10.
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: App
            private set
    }
}