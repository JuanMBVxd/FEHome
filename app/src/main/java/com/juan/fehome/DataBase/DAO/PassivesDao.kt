package com.juan.fehome.DataBase.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.juan.fehome.DataBase.entities.PassiveEntity

@Dao
interface PassivesDao{
    @Insert
    suspend fun insertPassive(passive: PassiveEntity)

    @Update
    suspend fun updatePassive(passive: PassiveEntity)

    @Delete
    suspend fun deletePassive(passive: PassiveEntity)

    @Query("SELECT * FROM passives")
    suspend fun getAllPassives(): List<PassiveEntity>
}