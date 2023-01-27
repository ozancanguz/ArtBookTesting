package com.ozancanguz.artbooktesting.repository

import androidx.lifecycle.LiveData
import com.ozancanguz.artbooktesting.data.api.ImageApi
import com.ozancanguz.artbooktesting.data.db.Art
import com.ozancanguz.artbooktesting.data.db.ArtDao
import com.ozancanguz.artbooktesting.data.model.ImageResponse
import com.ozancanguz.artbooktesting.util.Resource
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ArtRepository@Inject constructor(private val artDao: ArtDao,
                                       private val imageApi: ImageApi
                                       ):ArtRepositoryInterface {

    override suspend fun insertArt(art: Art) {
        artDao.insertArt(art)
    }

    override suspend fun deleteArt(art: Art) {
      artDao.deleteArt(art)
    }

    override fun getArt(): LiveData<List<Art>> {
        return artDao.observeArt()
    }

    override suspend fun searchImage(imageString: String): Resource<ImageResponse> {

        return try {

            val response=imageApi.imageSearch(imageString)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error",null)
            } else {
                Resource.error("Error",null)
            }
        } catch (e: Exception) {
            Resource.error("No data!",null)
        }
    }
}