package com.hedgehog.cleanarchitecture.di

import android.content.Context
import com.hedgehog.cleanarchitecture.data.repository.UserRepositoryImplementation
import com.hedgehog.cleanarchitecture.data.storage.UserStorage
import com.hedgehog.cleanarchitecture.data.storage.shared_prefs.SharedPrefUserStorage
import com.hedgehog.cleanarchitecture.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImplementation(userStorage = userStorage)
    }

}