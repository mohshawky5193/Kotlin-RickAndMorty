package dev.shawky.rickandmorty.model.remote

import dev.shawky.rickandmorty.model.Character
data class Result(
    val info: Info,
    val results: List<Character>
)