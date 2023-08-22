package com.example.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.ImageFragmentBinding

class ImageFragment : Fragment() {

    companion object {
        private const val ARGS_IMAGE = "image"

        fun createArgs(imageResId: Int): Bundle =
            bundleOf(ARGS_IMAGE to imageResId)
    }

    private lateinit var binding: ImageFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = ImageFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.photo.setImageResource(requireArguments().getInt(ARGS_IMAGE))

        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.backF.setOnClickListener {
            findNavController().popBackStack(R.id.firstFragment, false)
        }

    }

}