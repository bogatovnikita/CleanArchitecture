package com.hedgehog.cleanarchitecture.di

import android.content.Context
import com.hedgehog.cleanarchitecture.data.repository.UserRepositoryImplementation
import com.hedgehog.cleanarchitecture.data.storage.UserStorage
import com.hedgehog.cleanarchitecture.data.storage.shared_prefs.SharedPrefUserStorage
import com.hedgehog.cleanarchitecture.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImplementation(
            userStorage = userStorage
        )
    }

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }
}
