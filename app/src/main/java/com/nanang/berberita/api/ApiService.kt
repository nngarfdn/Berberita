package com.nanang.berberita.data.api


import com.nanang.beritaaja.data.model.News
import retrofit2.http.GET

interface ApiService {

    @GET("v2/top-headlines?country=id&apiKey=9768f48a22d5466994aad0ce84ac7688")
    suspend fun getTopNews(): News

}