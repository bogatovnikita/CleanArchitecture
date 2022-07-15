package com.hedgehog.cleanarchitecture.app

import android.app.Application
import com.hedgehog.cleanarchitecture.di.AppComponent
import com.hedgehog.cleanarchitecture.di.AppModule
import com.hedgehog.cleanarchitecture.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}