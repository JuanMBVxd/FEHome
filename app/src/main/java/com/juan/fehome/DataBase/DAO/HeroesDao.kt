package com.juan.fehome.DataBase.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.juan.fehome.DataBase.entities.HeroesEntity

@Dao
interface HeroesDao {
    @Insert
    suspend fun insertHero(hero: HeroesEntity)

    @Update
    suspend fun updateHero(hero: HeroesEntity)

    @Delete
    suspend fun deleteHero(hero: HeroesEntity)

    @Query("SELECT * FROM heroes")
    suspend fun getAllHeroes(): List<HeroesEntity>

    // Otros métodos de consulta según sea necesario
}