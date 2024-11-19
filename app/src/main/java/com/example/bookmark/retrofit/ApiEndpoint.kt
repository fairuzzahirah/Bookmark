package com.example.bookmark.retrofit

import com.example.bookmark.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("character")
    fun getCharacter(): Call<List<MainModel>>  // Get character list from API
}
