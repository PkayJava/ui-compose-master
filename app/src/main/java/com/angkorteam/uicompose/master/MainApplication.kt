package com.angkorteam.uicompose.master

import android.app.Application

class MainApplication : Application() {

    lateinit var appDatabase: AppDatabase

    override fun onCreate() {
        super.onCreate()

        this.appDatabase = AppDatabase.getInstance(this)
    }

}