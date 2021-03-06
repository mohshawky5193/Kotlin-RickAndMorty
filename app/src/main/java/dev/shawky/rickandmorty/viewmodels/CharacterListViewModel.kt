package dev.shawky.rickandmorty.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dev.shawky.rickandmorty.model.Character
import dev.shawky.rickandmorty.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow

class CharacterListViewModel(val characterRepository: CharacterRepository) : ViewModel() {


    fun getCharacterListPaginated(): Flow<PagingData<Character>> {
        return characterRepository.getCharacterListPaginated().cachedIn(viewModelScope)
    }
}