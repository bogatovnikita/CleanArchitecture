package com.hedgehog.cleanarchitecture.data.repository

import android.content.Context
import com.hedgehog.cleanarchitecture.domain.model.SaveUserNameParam
import com.hedgehog.cleanarchitecture.domain.model.UserName
import com.hedgehog.cleanarchitecture.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "SHARED_PREFS_NAME"
private const val KEY_FIRST_NAME = "KEY_FIRST_NAME"
private const val KEY_SECOND_NAME = "KEY_SECOND_NAME"
private const val KEY_DEFAULT_NAME = "KEY_DEFAULT_NAME"

class UserRepositoryImplementation(context: Context) : UserRepository {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.name).apply()
        return true
    }

    override fun getName(): UserName {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val secondName = sharedPreferences.getString(KEY_SECOND_NAME, KEY_DEFAULT_NAME) ?: KEY_DEFAULT_NAME

        return UserName(firstName = firstName, secondName = secondName)
    }
}