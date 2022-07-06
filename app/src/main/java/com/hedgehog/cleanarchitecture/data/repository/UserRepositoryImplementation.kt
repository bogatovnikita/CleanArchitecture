package com.hedgehog.cleanarchitecture.data.repository

import com.hedgehog.cleanarchitecture.data.storage.models.User
import com.hedgehog.cleanarchitecture.data.storage.UserStorage
import com.hedgehog.cleanarchitecture.domain.model.SaveUserNameParam
import com.hedgehog.cleanarchitecture.domain.model.UserName
import com.hedgehog.cleanarchitecture.domain.repository.UserRepository

class UserRepositoryImplementation(private val userStorage: UserStorage) : UserRepository {
    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = User(firstName = saveParam.name, lastName = "")
        return userStorage.save(user = user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        val userName = UserName(firstName = user.firstName, secondName = user.lastName)
        return userName
    }
}