package dev.shawky.rickandmorty.model.remote

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: String
)