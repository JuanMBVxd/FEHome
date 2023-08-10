package com.juan.fehome.DataBase.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.juan.fehome.DataBase.entities.BuildCustomEntity

@Dao
interface BuildsCustomsDao{
    @Insert
    suspend fun insertBuildCustom(buildCustom: BuildCustomEntity)

    @Update
    suspend fun updateBuildCustom(buildCustom: BuildCustomEntity)

    @Delete
    suspend fun deleteBuildCustom(buildCustom: BuildCustomEntity)

    @Query("SELECT * FROM builds_customs")
    suspend fun getAllBuildCustoms(): List<BuildCustomEntity>
}