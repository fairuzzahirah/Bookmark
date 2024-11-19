package com.example.bookmark

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class MainModel(
    @PrimaryKey val _id: Int,
    val name: String,
    val imageUrl: String,
    var isFavorite: Boolean // Marks whether the character is a favorite
)
