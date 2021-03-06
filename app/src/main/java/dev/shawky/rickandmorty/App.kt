package dev.shawky.rickandmorty

import android.app.Application
import dev.shawky.rickandmorty.di.AppComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        configureDI();
    }

    private fun configureDI() {
        startKoin {
            androidContext(this@App)
            modules(AppComponent);
        }
    }
}