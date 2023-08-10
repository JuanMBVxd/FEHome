package com.juan.fehome.DataBase.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "weapons",
    foreignKeys = [
        ForeignKey(
            entity = WeaponEffectEntity::class,
            parentColumns = ["id_weapon_effect"],
            childColumns = ["base_effect_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = WeaponEffectEntity::class,
            parentColumns = ["id_weapon_effect"],
            childColumns = ["refine_prf_effect_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = WeaponEffectEntity::class,
            parentColumns = ["id_weapon_effect"],
            childColumns = ["refine_effect_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class WeaponEntity(
    @PrimaryKey(autoGenerate = true) val id_weapon: Int = 0,
    val name: String,
    val base_effect_id: Int,
    val weapon_type: String,
    val color_weapon: String,
    val might: Int,
    val range: Int,
    val sp_cost: Int?,
    val exclusive: Int,
    val refinable_prf: Int,
    val refine_prf_effect_id: Int?,
    val refinable: Int,
    val refine_effect_id: Int?
)