package com.ozancanguz.artbooktesting.repository

import androidx.lifecycle.LiveData
import com.ozancanguz.artbooktesting.data.db.Art
import com.ozancanguz.artbooktesting.data.model.ImageResponse
import com.ozancanguz.artbooktesting.util.Resource
import dagger.hilt.android.scopes.ViewModelScoped

@ViewModelScoped
interface ArtRepositoryInterface {

    suspend fun insertArt(art: Art)

    suspend fun deleteArt(art: Art)

   fun getArt():LiveData<List<Art>>

   suspend fun searchImage(imageString: String): Resource<ImageResponse>

}