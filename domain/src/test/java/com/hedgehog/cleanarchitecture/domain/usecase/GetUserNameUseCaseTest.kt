package com.hedgehog.cleanarchitecture.domain.usecase

import com.hedgehog.cleanarchitecture.domain.model.UserName
import com.hedgehog.cleanarchitecture.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetUserNameUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @Test
    fun showResult() {

        val testUserName = UserName(firstName = "Nikita", secondName = "Bogatov")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = GetUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute()
        val expected = UserName(firstName = "Nikita", secondName = "Bogatov")

        Assertions.assertEquals(expected, actual)
    }
}