package com.ozancanguz.artbooktesting.ui.artfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozancanguz.artbooktesting.R
import com.ozancanguz.artbooktesting.databinding.FragmentArtsBinding


class ArtsFragment : Fragment() {

    private var _binding: FragmentArtsBinding? = null

    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         _binding = FragmentArtsBinding.inflate(inflater, container, false)
        val view = binding.root





        return view
    }


}