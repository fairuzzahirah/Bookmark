package com.example.bookmark.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.bookmark.MainModel

@Dao
interface CharacterDao {
    @Insert
    suspend fun insertCharacters(characters: List<MainModel>)

    @Update
    suspend fun updateCharacter(character: MainModel)

    @Query("SELECT * FROM characters")
    fun getAllCharacters(): LiveData<List<MainModel>>  // Fetch all characters

    @Query("SELECT * FROM characters WHERE isFavorite = 1")
    fun getFavoriteCharacters(): LiveData<List<MainModel>>  // Fetch only favorite characters
}
