package dev.shawky.rickandmorty.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.shawky.rickandmorty.database.dao.CharacterDao
import dev.shawky.rickandmorty.model.Character

@Database(
    entities = [Character::class],
    version=1,
    exportSchema = false
)
abstract  class CharactersDatabase : RoomDatabase() {

    abstract  fun characterDao(): CharacterDao
}