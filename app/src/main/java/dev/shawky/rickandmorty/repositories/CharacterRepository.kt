package dev.shawky.rickandmorty.repositories

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dev.shawky.rickandmorty.database.dao.CharacterDao
import dev.shawky.rickandmorty.model.Character
import dev.shawky.rickandmorty.network.CharactersService
import kotlinx.coroutines.flow.Flow

class CharacterRepository (val charactersService: CharactersService, val characterDao:CharacterDao){
    @OptIn(ExperimentalPagingApi::class)
    fun getCharacterListPaginated(): Flow<PagingData<Character>> {
        val pagingSourceFactory = { characterDao.getAllCharacters()}
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = true,

            ),
            pagingSourceFactory =pagingSourceFactory,
            remoteMediator = CharactersRemoteMediator(charactersService,characterDao)
        ).flow
    }


    suspend fun getCharacterById(id:Int):Character {
        return characterDao.getCharacterById(id);
    }
}