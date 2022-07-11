package com.hedgehog.cleanarchitecture.domain.repository

import com.hedgehog.cleanarchitecture.domain.model.SaveUserNameParam
import com.hedgehog.cleanarchitecture.domain.model.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}