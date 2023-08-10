package com.juan.fehome.DataBase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weapon_effects")
data class WeaponEffectEntity(
    @PrimaryKey(autoGenerate = true) val id_weapon_effect: Int = 0,
    val effect: String,
    val hp_boost: Int?,
    val atk_boost: Int?,
    val spd_boost: Int?,
    val def_boost: Int?,
    val res_boost: Int?,
    val image_icon: String?
)