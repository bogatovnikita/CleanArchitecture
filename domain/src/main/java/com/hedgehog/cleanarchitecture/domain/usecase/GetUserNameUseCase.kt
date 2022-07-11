package com.hedgehog.cleanarchitecture.domain.usecase

import com.hedgehog.cleanarchitecture.domain.model.UserName
import com.hedgehog.cleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}