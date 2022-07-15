package com.hedgehog.cleanarchitecture.di

import com.hedgehog.cleanarchitecture.domain.repository.UserRepository
import com.hedgehog.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.hedgehog.cleanarchitecture.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase {
        return GetUserNameUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository = userRepository)
    }
}