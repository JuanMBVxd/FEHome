package com.juan.fehome.DataBase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "specials")
data class SpecialEntity(
    @PrimaryKey(autoGenerate = true) val id_special: Int = 0,
    val name: String,
    val effect: String,
    val cooldown: Int,
    val sp_cost: Int?,
    val weapon_type_restriction: String,
    val exclusive: Int,
    val healer_skill: Int
)