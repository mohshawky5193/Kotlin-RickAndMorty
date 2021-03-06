package dev.shawky.rickandmorty.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import dev.shawky.rickandmorty.R
import dev.shawky.rickandmorty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityMainBinding :ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)



    }
}