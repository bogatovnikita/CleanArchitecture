package com.hedgehog.cleanarchitecture.domain.usecase

import com.hedgehog.cleanarchitecture.domain.model.SaveUserNameParam
import com.hedgehog.cleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean {
        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}