package com.hedgehog.cleanarchitecture.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.hedgehog.cleanarchitecture.databinding.FragmentSecondExampleBinding

class SecondExampleFragment : Fragment() {

    private val navArgs by navArgs<SecondExampleFragmentArgs>()

    private var _binding: FragmentSecondExampleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondExampleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (navArgs.text == "") {
            binding.titleTv.text = navArgs.text
        }else{
            binding.titleTv.text = "Аргументов нет"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}