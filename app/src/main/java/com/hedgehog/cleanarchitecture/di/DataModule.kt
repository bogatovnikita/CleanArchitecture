package com.hedgehog.cleanarchitecture.di

import com.hedgehog.cleanarchitecture.data.repository.UserRepositoryImplementation
import com.hedgehog.cleanarchitecture.data.storage.UserStorage
import com.hedgehog.cleanarchitecture.data.storage.shared_prefs.SharedPrefUserStorage
import com.hedgehog.cleanarchitecture.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImplementation(userStorage = get())
    }
}
