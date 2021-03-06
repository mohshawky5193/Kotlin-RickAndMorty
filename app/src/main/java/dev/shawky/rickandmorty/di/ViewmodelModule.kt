package dev.shawky.rickandmorty.di

import dev.shawky.rickandmorty.viewmodels.CharacterDetailViewModel
import dev.shawky.rickandmorty.viewmodels.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel {CharacterListViewModel(get())}
    viewModel { CharacterDetailViewModel(get()) }
}