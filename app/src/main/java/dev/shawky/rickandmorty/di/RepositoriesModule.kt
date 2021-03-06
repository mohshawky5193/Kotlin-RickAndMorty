package dev.shawky.rickandmorty.di

import dev.shawky.rickandmorty.repositories.CharacterRepository
import org.koin.dsl.module

val repositoriesModule = module {
    single { CharacterRepository(get(),get())}
}