package com.example.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.FactFragmentBinding

class FactFragment : Fragment() {

    companion object {
        private const val ARGS_FACT = "fact"

        fun createArgs(fact: String): Bundle =
            bundleOf(ARGS_FACT to fact)
    }

    private lateinit var binding: FactFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FactFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fact = requireArguments().getString(ARGS_FACT)

        binding.textView.text = fact

        val imageId = if (fact.equals("Хорьки очень крутые")) R.drawable.ph1 else R.drawable.ph2

        binding.watch.setOnClickListener {
            findNavController().navigate(R.id.action_factFragment_to_imageFragment,
                ImageFragment.createArgs(imageId))
        }

        binding.backB.setOnClickListener {
            findNavController().navigateUp()
        }

    }

}