package com.hedgehog.cleanarchitecture.di

import com.hedgehog.cleanarchitecture.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}