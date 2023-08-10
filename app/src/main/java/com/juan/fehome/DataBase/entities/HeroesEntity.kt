package com.juan.fehome.DataBase.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "heroes",
    foreignKeys = [
        ForeignKey(
            entity = HeroStatsEntity::class,
            parentColumns = ["id_hero_stats"],
            childColumns = ["hero_stats_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class HeroesEntity(
    @PrimaryKey val id_heroes: Int,
    val name: String,
    val title: String,
    val legendary: Int,
    val legendary_element: String?,
    val legendary_buff: String?,
    val new_hero: Int,
    val seasonal: Int,
    val seasonal_type: String?,
    val duo: Int,
    val duo_skill: String?,
    val harmonic: Int,
    val harmonic_skill: String?,
    val min_rarity: Int,
    val max_rarity: Int,
    val weapon_type: String,
    val color: String,
    val move_type: String,
    val hero_stats_id: Int,
    val image_thumbnail: String,
    val image_full1: String,
    val image_full2: String?,
    val image_full3: String?,
    val image_full4: String?
)