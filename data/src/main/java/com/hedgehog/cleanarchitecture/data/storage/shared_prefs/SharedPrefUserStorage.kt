package com.hedgehog.cleanarchitecture.data.storage.shared_prefs

import android.content.Context
import com.hedgehog.cleanarchitecture.data.storage.UserStorage
import com.hedgehog.cleanarchitecture.data.storage.models.User

private const val SHARED_PREFS_NAME = "SHARED_PREFS_NAME"
private const val KEY_FIRST_NAME = "KEY_FIRST_NAME"
private const val KEY_LAST_NAME = "KEY_LAST_NAME"
private const val KEY_DEFAULT_FIRST_NAME = "KEY_DEFAULT_FIRST_NAME"
private const val KEY_DEFAULT_LAST_NAME = "KEY_DEFAULT_LAST_NAME"

class SharedPrefUserStorage(context: Context) : UserStorage {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()

        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, KEY_DEFAULT_FIRST_NAME)
            ?: KEY_DEFAULT_FIRST_NAME
        val secondName =
            sharedPreferences.getString(KEY_LAST_NAME, KEY_DEFAULT_LAST_NAME)
                ?: KEY_DEFAULT_LAST_NAME

        return User(firstName = firstName, lastName = secondName)
    }
}