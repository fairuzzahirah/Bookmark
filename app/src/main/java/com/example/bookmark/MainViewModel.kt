package com.example.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookmark.database.CharacterRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _characters = MutableLiveData<List<MainModel>>()
    val characters: LiveData<List<MainModel>> get() = _characters

    private val _favoriteCharacters = MutableLiveData<List<MainModel>>()
    val favoriteCharacters: LiveData<List<MainModel>> get() = _favoriteCharacters

    private val repository = CharacterRepository()

    // Fetch characters from the API
    fun fetchCharacters() {
        viewModelScope.launch {
            val characterList = repository.fetchCharacters()
            _characters.value = characterList
        }
    }

    // Add a character to the favorites list
    fun addCharacterToFavorites(character: MainModel) {
        val updatedList = _favoriteCharacters.value?.toMutableList() ?: mutableListOf()
        if (!updatedList.contains(character)) {
            updatedList.add(character)
            _favoriteCharacters.value = updatedList
        }
    }

    // Remove a character from the favorites list
    fun removeCharacterFromFavorites(character: MainModel) {
        val updatedList = _favoriteCharacters.value?.toMutableList() ?: mutableListOf()
        updatedList.remove(character)
        _favoriteCharacters.value = updatedList
    }
}
