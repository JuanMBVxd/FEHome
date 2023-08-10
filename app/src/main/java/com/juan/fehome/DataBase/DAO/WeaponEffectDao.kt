package com.juan.fehome.DataBase.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.juan.fehome.DataBase.entities.WeaponEffectEntity

@Dao
interface WeaponEffectDao{
    @Insert
    suspend fun insertWeaponEffect(weaponEffect: WeaponEffectEntity)

    @Update
    suspend fun updateWeaponEffect(weaponEffect: WeaponEffectEntity)

    @Delete
    suspend fun deleteWeaponEffect(weaponEffect: WeaponEffectEntity)

    @Query("SELECT * FROM weapon_effects")
    suspend fun getAllWeaponEffects(): List<WeaponEffectEntity>
}