package dev.shawky.rickandmorty.di

import androidx.room.Room
import dev.shawky.rickandmorty.R
import dev.shawky.rickandmorty.database.CharactersDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule= module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            CharactersDatabase::class.java,
            androidApplication().baseContext.getString(R.string.app_name)
        ).build()
    }

    single {
        get<CharactersDatabase>().characterDao()
    }
}