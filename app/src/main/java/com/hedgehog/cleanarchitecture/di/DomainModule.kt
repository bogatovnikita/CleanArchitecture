package com.hedgehog.cleanarchitecture.di

import com.hedgehog.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.hedgehog.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }
}
