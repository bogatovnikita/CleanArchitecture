package com.hedgehog.cleanarchitecture.di

import com.hedgehog.cleanarchitecture.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(getUserNameUseCase = get(), saveUserNameUseCase = get())
    }
}