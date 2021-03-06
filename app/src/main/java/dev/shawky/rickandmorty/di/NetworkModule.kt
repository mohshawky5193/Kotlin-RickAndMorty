package dev.shawky.rickandmorty.di

import dev.shawky.rickandmorty.network.CharactersService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val networkModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    single {
        get<Retrofit>().create<CharactersService>()
    }

    single<HttpLoggingInterceptor> {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
    }

    single<OkHttpClient> {
        OkHttpClient.Builder().addInterceptor(get<HttpLoggingInterceptor>()).build()
    }
}