package com.cj3dreams.aliftesttask.presentation

import android.app.Application
import com.cj3dreams.aliftesttask.di.dataDb
import com.cj3dreams.aliftesttask.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(dataDb, networkModule)
        }
    }
}