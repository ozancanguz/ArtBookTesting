package com.ozancanguz.artbooktesting.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.ozancanguz.artbooktesting.ui.artdetails.ArtDetailsFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class ArtFragmentFactory @Inject constructor(

    private val glide : RequestManager,

    ) : FragmentFactory() {

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            ArtDetailsFragment::class.java.name -> ArtDetailsFragment(glide)
            else -> super.instantiate(classLoader, className)
        }
    }
}