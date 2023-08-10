package com.juan.fehome.DataBase.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.juan.fehome.DataBase.entities.HeroStatsEntity

@Dao
interface HeroStatsDao {
    @Insert
    suspend fun insertHeroStats(heroStats: HeroStatsEntity)

    @Update
    suspend fun updateHeroStats(heroStats: HeroStatsEntity)

    @Delete
    suspend fun deleteHeroStats(heroStats: HeroStatsEntity)

    @Query("SELECT * FROM heroes")
    suspend fun getAllHeroStats(): List<HeroStatsEntity>

    // Otros métodos de consulta según sea necesario
}