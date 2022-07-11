package com.hedgehog.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hedgehog.cleanarchitecture.data.repository.UserRepositoryImplementation
import com.hedgehog.cleanarchitecture.data.storage.shared_prefs.SharedPrefUserStorage
import com.hedgehog.cleanarchitecture.databinding.ActivityMainBinding
import com.hedgehog.cleanarchitecture.domain.model.SaveUserNameParam
import com.hedgehog.cleanarchitecture.domain.repository.UserRepository
import com.hedgehog.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.hedgehog.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImplementation(
            userStorage = SharedPrefUserStorage(context = applicationContext)
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSaveData.setOnClickListener {
            val text = binding.editTextData.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param = params)
            binding.textData.text = "Save result = $result"
        }

        binding.buttonGetData.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            binding.textData.text = "${userName.firstName} ${userName.secondName}"
        }
    }
}