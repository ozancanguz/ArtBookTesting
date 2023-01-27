package com.ozancanguz.artbooktesting.data.api

import com.ozancanguz.artbooktesting.data.model.ImageResponse
import com.ozancanguz.artbooktesting.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {


    @GET("api/")
    suspend fun imageSearch(@Query("q")searchquery:String,
                             @Query("key")key:String=API_KEY
                                  ):Response<ImageResponse>
}