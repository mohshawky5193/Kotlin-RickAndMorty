package dev.shawky.rickandmorty.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.shawky.rickandmorty.model.Character;

@Dao
interface CharacterDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters:List<Character>)

    @Query("Delete from Character")
    suspend fun clearCharacters()
    @Query("Select * from  Character")
    fun getAllCharacters() : PagingSource<Int, Character>
    @Query("Select * from Character where id= :id")
    suspend  fun getCharacterById(id:Int):Character
}