package com.example.educenterroommvvm.app

import android.app.Application
import com.example.educenterroommvvm.database.AppDatabase

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        AppDatabase.init(this)
    }
}