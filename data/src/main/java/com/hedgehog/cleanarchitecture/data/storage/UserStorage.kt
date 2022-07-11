package com.hedgehog.cleanarchitecture.data.storage

import com.hedgehog.cleanarchitecture.data.storage.models.User

interface UserStorage {
    fun save(user: User): Boolean

    fun get(): User
}