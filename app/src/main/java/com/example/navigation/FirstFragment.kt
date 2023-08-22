package com.example.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.FirstFragmentBinding

class FirstFragment : Fragment() {


    private lateinit var binding: FirstFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FirstFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageView.setImageResource(R.drawable.mainph)

        binding.button.setOnClickListener {
            findNavController().navigate(
                R.id.action_firstFragment_to_factFragment,
                FactFragment.createArgs("Хорьки очень крутые"))

        }

        binding.button2.setOnClickListener {
            findNavController().navigate(
                R.id.action_firstFragment_to_factFragment,
                FactFragment.createArgs("Выдры очень крутые"))        }
    }
}