package dev.shawky.rickandmorty.di

val AppComponent = listOf(
    databaseModule,
    networkModule,
    viewmodelModule,
    repositoriesModule,)