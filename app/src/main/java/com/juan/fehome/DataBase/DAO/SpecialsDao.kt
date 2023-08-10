package com.juan.fehome.DataBase.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.juan.fehome.DataBase.entities.SpecialEntity

@Dao
interface SpecialsDao{
    @Insert
    suspend fun insertSpecial(special: SpecialEntity)

    @Update
    suspend fun updateSpecial(special: SpecialEntity)

    @Delete
    suspend fun deleteSpecial(special: SpecialEntity)

    @Query("SELECT * FROM specials")
    suspend fun getAllSpecials(): List<SpecialEntity>
}