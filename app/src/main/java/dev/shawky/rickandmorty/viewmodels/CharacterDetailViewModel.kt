package dev.shawky.rickandmorty.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dev.shawky.rickandmorty.repositories.CharacterRepository
import dev.shawky.rickandmorty.model.Character
import kotlinx.coroutines.Dispatchers

class CharacterDetailViewModel(val characterRepository: CharacterRepository) :ViewModel() {



    fun getCharacterById(id:Int):LiveData<Character> = liveData(
        context = Dispatchers.IO,
        block = {
            emit(characterRepository.getCharacterById(id))
        }
    )
}