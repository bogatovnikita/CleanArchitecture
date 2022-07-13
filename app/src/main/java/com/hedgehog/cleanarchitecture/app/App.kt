package com.hedgehog.cleanarchitecture.app

import android.app.Application
import com.hedgehog.cleanarchitecture.di.appModule
import com.hedgehog.cleanarchitecture.di.dataModule
import com.hedgehog.cleanarchitecture.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(appModule, dataModule, domainModule)
        }
    }
}