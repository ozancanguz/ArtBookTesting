package com.ozancanguz.artbooktesting.ui.artfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.artbooktesting.R
import com.ozancanguz.artbooktesting.adapter.ArtRecyclerAdapter
import com.ozancanguz.artbooktesting.databinding.FragmentArtsBinding
import com.ozancanguz.artbooktesting.viewmodel.ArtViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArtsFragment@Inject constructor(val artRecyclerAdapter: ArtRecyclerAdapter) : Fragment() {

    private var _binding: FragmentArtsBinding? = null

    private val binding get() = _binding!!

    private val artViewModel:ArtViewModel by viewModels()
    private val swipeCallBack = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val layoutPosition = viewHolder.layoutPosition
            val selectedArt = artRecyclerAdapter.arts[layoutPosition]
            artViewModel.deleteArt(selectedArt)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         _binding = FragmentArtsBinding.inflate(inflater, container, false)
        val view = binding.root

        subscribetoObservers()

        setupRv()


        binding.fab.setOnClickListener{
            findNavController().navigate(R.id.action_artsFragment_to_artDetailsFragment)
        }


        return view
    }

    private fun setupRv() {
        binding.recyclerViewArt.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerViewArt.adapter=artRecyclerAdapter
        ItemTouchHelper(swipeCallBack).attachToRecyclerView(binding.recyclerViewArt)
    }

    private fun subscribetoObservers(){
        artViewModel.artList.observe(viewLifecycleOwner, Observer {
            artRecyclerAdapter.arts=it
        })
    }


}