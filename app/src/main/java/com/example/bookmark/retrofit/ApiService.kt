package com.example.bookmark.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getCharacter(): ApiResponse  // Fetch character data using suspend for async calls

    companion object {
        val endpoint: ApiService by lazy {
            Retrofit.Builder()
                .baseUrl("https://api.disneyapi.dev/")  // Replace with the actual base URL
                .addConverterFactory(GsonConverterFactory.create())  // Gson converter for JSON parsing
                .build()
                .create(ApiService::class.java)  // Create instance of ApiService
        }
    }
}
