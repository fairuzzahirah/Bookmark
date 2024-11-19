package com.example.bookmark.database

import com.example.bookmark.MainModel
import com.example.bookmark.retrofit.ApiService
import com.example.bookmark.retrofit.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterRepository {

    private val apiService = ApiService.endpoint

    suspend fun fetchCharacters(): List<MainModel> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getCharacter()
            response.data
        }
    }
}
