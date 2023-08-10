package com.juan.fehome.DataBase.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "build_base",
    foreignKeys = [
        ForeignKey(
            entity = HeroesEntity::class,
            parentColumns = ["id_heroes"],
            childColumns = ["hero_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = WeaponEntity::class,
            parentColumns = ["id_weapon"],
            childColumns = ["weapon_prf_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = WeaponEntity::class,
            parentColumns = ["id_weapon"],
            childColumns = ["weapon_no_prf_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = AssistEntity::class,
            parentColumns = ["id_assist"],
            childColumns = ["assist_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = SpecialEntity::class,
            parentColumns = ["id_special"],
            childColumns = ["special_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = PassiveEntity::class,
            parentColumns = ["id_passive"],
            childColumns = ["passive_a_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = PassiveEntity::class,
            parentColumns = ["id_passive"],
            childColumns = ["passive_b_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = PassiveEntity::class,
            parentColumns = ["id_passive"],
            childColumns = ["passive_c_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class BuildBaseEntity(
    @PrimaryKey(autoGenerate = true) val id_build_base: Int = 0,
    val hero_id: Int,
    val weapon_prf_id: Int,
    val weapon_no_prf_id: Int,
    val assist_id: Int,
    val special_id: Int,
    val passive_a_id: Int,
    val passive_b_id: Int,
    val passive_c_id: Int
)