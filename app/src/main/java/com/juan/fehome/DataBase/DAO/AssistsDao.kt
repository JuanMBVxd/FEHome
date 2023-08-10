package com.juan.fehome.DataBase.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.juan.fehome.DataBase.entities.AssistEntity

@Dao
interface AssistsDao{
    @Insert
    suspend fun insertAssist(assist: AssistEntity)

    @Update
    suspend fun updateAssist(assist: AssistEntity)

    @Delete
    suspend fun deleteAssist(assist: AssistEntity)

    @Query("SELECT * FROM assists")
    suspend fun getAllAssists(): List<AssistEntity>

}