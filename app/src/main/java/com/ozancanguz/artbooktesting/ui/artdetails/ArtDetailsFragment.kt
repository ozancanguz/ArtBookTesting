package com.ozancanguz.artbooktesting.ui.artdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.RequestManager
import com.ozancanguz.artbooktesting.R
import com.ozancanguz.artbooktesting.databinding.FragmentArtDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArtDetailsFragment@Inject constructor(val glide:RequestManager ): Fragment() {

    private var _binding: FragmentArtDetailsBinding? = null

    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          _binding = FragmentArtDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.artImageView.setOnClickListener {
            findNavController().navigate(R.id.action_artDetailsFragment_to_imageApiFragment)
        }


        return view
    }


}