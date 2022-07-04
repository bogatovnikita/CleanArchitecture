package com.hedgehog.cleanarchitecture.domain.usecase

import com.hedgehog.cleanarchitecture.domain.model.UserName

class GetUserNameUseCase {
    fun execute(): UserName {
        return UserName(firstName = "Nikita", secondName = "Bogatov")
    }
}