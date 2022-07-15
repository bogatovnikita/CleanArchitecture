package com.hedgehog.cleanarchitecture.di

import android.content.Context
import com.hedgehog.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.hedgehog.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import com.hedgehog.cleanarchitecture.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )

    }
}