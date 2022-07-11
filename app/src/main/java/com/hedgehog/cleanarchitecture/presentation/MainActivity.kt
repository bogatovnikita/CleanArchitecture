package com.hedgehog.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.hedgehog.cleanarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels { this.mainViewModelFactory }

    private val mainViewModelFactory = MainViewModelFactory(context = this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObservers()

        binding.buttonSaveData.setOnClickListener {
            val text = binding.editTextData.text.toString()
            viewModel.save(text)
        }

        binding.buttonGetData.setOnClickListener {
            viewModel.load()
        }
    }

    private fun initObservers() {
        viewModel.resultLiveData.observe(this) {
            binding.textData.text = it
        }
    }
}