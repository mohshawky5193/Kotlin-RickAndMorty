package dev.shawky.rickandmorty.repositories

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import dev.shawky.rickandmorty.database.dao.CharacterDao
import dev.shawky.rickandmorty.network.CharactersService
import dev.shawky.rickandmorty.model.Character
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class CharactersRemoteMediator(
    val charactersService: CharactersService,
    val characterDao: CharacterDao
) : RemoteMediator<Int, Character>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Character>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> {
                state.anchorPosition?.let { position ->
                    state.closestItemToPosition(position)?.page ?: 1
                } ?: 1
            }
            LoadType.PREPEND -> {
                state.pages.firstOrNull() { it.data.isNotEmpty() }?.data?.firstOrNull()
                    ?.let { character ->
                        character.page?.minus(1)
                    }
            }
            LoadType.APPEND -> {
                state.pages.lastOrNull() { it.data.isNotEmpty() }?.data?.lastOrNull()
                    ?.let { character ->
                        character.page?.plus(1)
                    }
            }
        }
        try {
            if (page != null && page > 0) {
                val apiResponse = charactersService.getCharactersPaginated(page)
                val characters = apiResponse.results
                Log.d("Shawky","Characters Size:${characters.size}")
                val endOfPaginationReached = characters.isEmpty()
                characters.forEach {
                    it.page = page
                }
                characterDao.insertCharacters(characters = characters)
                return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
            }else{
                return MediatorResult.Success(endOfPaginationReached = false);
            }
        } catch (exception: IOException) {
            return MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            return MediatorResult.Error(exception)
        }
    }
}