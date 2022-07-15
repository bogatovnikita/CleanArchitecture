package com.hedgehog.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.hedgehog.cleanarchitecture.app.App
import com.hedgehog.cleanarchitecture.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        (applicationContext as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
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