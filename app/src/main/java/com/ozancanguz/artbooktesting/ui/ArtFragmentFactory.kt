package com.ozancanguz.artbooktesting.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.ozancanguz.artbooktesting.adapter.ArtRecyclerAdapter
import com.ozancanguz.artbooktesting.adapter.ImageRecyclerAdapter
import com.ozancanguz.artbooktesting.ui.artdetails.ArtDetailsFragment
import com.ozancanguz.artbooktesting.ui.artfragment.ArtsFragment
import com.ozancanguz.artbooktesting.ui.imageApiFragment.ImageApiFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class ArtFragmentFactory @Inject constructor(
    private val imageRecyclerAdapter: ImageRecyclerAdapter,
    private val glide : RequestManager,
    private val artRecyclerAdapter: ArtRecyclerAdapter
) : FragmentFactory() {

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            ImageApiFragment::class.java.name -> ImageApiFragment(imageRecyclerAdapter)
            ArtDetailsFragment::class.java.name -> ArtDetailsFragment(glide)
            ArtsFragment::class.java.name -> ArtsFragment(artRecyclerAdapter)
            else -> super.instantiate(classLoader, className)
        }
    }
}