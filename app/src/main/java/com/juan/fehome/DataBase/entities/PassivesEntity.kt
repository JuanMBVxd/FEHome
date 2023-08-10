package com.juan.fehome.DataBase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "passives")
data class PassiveEntity(
    @PrimaryKey(autoGenerate = true) val id_passive: Int = 0,
    val name: String,
    val effect: String,
    val hp_boost: Int?,
    val atk_boost: Int?,
    val spd_boost: Int?,
    val def_boost: Int?,
    val res_boost: Int?,
    val sp_cost: Int?,
    val slot: String,
    val seal: Int,
    val exclusive: Int,
    val move_type: String,
    val color_restriction: String,
    val range: Int,
    val healer_skill: Int
)