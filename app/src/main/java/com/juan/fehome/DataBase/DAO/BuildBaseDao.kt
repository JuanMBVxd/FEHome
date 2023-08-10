package com.juan.fehome.DataBase.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.juan.fehome.DataBase.entities.BuildBaseEntity

@Dao
interface BuildBaseDao{
    @Insert
    suspend fun insertBuildBase(buildBase: BuildBaseEntity)

    @Update
    suspend fun updateBuildBase(buildBase: BuildBaseEntity)

    @Delete
    suspend fun  deleteBuildBase(buildBase: BuildBaseEntity)

    @Query("SELECT * FROM build_base")
    suspend fun getAllBuildBase(): List<BuildBaseEntity>
}