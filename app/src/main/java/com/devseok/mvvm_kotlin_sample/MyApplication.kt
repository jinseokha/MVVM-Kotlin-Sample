package com.devseok.mvvm_kotlin_sample

import android.app.Application
import com.devseok.mvvm_kotlin_sample.di.myDiModule
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, myDiModule)
    }
}