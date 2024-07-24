package com.hedgehog.cleanarchitecture.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hedgehog.cleanarchitecture.databinding.FragmentGeneralScreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GeneralScreenFragment : Fragment() {

    private var _binding: FragmentGeneralScreenBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGeneralScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()

        binding.buttonSaveData.setOnClickListener {
            val text = binding.editTextData.text.toString()
            viewModel.save(text)
        }

        binding.buttonGetData.setOnClickListener {
            viewModel.load()
        }

        binding.nextScreenBtn.setOnClickListener {
            findNavController().navigate(
                GeneralScreenFragmentDirections.actionGeneralScreenFragmentToSecondExampleFragment(
                    text = "GGGGGGGGGG"
                )
            )
        }
    }

    private fun initObservers() {
        viewModel.resultLiveData.observe(viewLifecycleOwner) {
            binding.textData.text = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}