package com.hedgehog.cleanarchitecture.domain.usecase

import com.hedgehog.cleanarchitecture.domain.model.SaveUserNameParam

class SaveUserNameUseCase {
    fun execute(param: SaveUserNameParam): Boolean {
        if (param.name.isEmpty()) {
            return false
        } else {
            return true
        }
    }
}