package com.juan.fehome.DataBase.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.juan.fehome.DataBase.entities.WeaponEntity

@Dao
interface WeaponsDao{
    @Insert
    suspend fun insertWeapon(weapon: WeaponEntity)

    @Update
    suspend fun updateWeapon(weapon: WeaponEntity)

    @Delete
    suspend fun deleteWeapon(weapon: WeaponEntity)

    @Query("SELECT * FROM weapons")
    suspend fun getAllWeapons(): List<WeaponEntity>

}