package com.ozancanguz.artbooktesting.ui.imageApiFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozancanguz.artbooktesting.adapter.ArtRecyclerAdapter
import com.ozancanguz.artbooktesting.databinding.FragmentImageApiBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ImageApiFragment@Inject constructor(private val imageRecyclerAdapter: ArtRecyclerAdapter) : Fragment() {

    private var _binding: FragmentImageApiBinding? = null

    private val binding get() = _binding!!




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          _binding = FragmentImageApiBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }


}