package dev.shawky.rickandmorty.network

import retrofit2.http.GET
import retrofit2.http.Query
import dev.shawky.rickandmorty.model.remote.Result

interface CharactersService {

    @GET("character/")
    suspend fun getCharactersPaginated(@Query("page") page:Int?): Result
}