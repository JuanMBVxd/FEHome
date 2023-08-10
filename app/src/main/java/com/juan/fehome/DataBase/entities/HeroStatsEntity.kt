package com.juan.fehome.DataBase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hero_stats")
data class HeroStatsEntity(
    @PrimaryKey(autoGenerate = true) val id_hero_stats: Int = 0,
    val hp_base: Int,
    val atk_base: Int,
    val spd_base: Int,
    val def_base: Int,
    val res_base: Int,
    val hp_boon: Int,
    val atk_boon: Int,
    val spd_boon: Int,
    val def_boon: Int,
    val res_boon: Int,
    val hp_bane: Int,
    val atk_bane: Int,
    val spd_bane: Int,
    val def_bane: Int,
    val res_bane: Int
)