package com.juan.fehome.DataBase.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "builds_customs",
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
            childColumns = ["weapon_id"],
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
        ),
        ForeignKey(
            entity = PassiveEntity::class,
            parentColumns = ["id_passive"],
            childColumns = ["passive_s_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class BuildCustomEntity(
    @PrimaryKey(autoGenerate = true) val id_build_custom: Int = 0,
    val hero_id: Int,
    val merges: Int = 0,
    val dracoflowers: Int = 0,
    val asset: String?,
    val ascended_asset: String?,
    val flaw: String?,
    val summon_support: Int,
    val weapon_id: Int?,
    val assist_id: Int?,
    val special_id: Int?,
    val passive_a_id: Int?,
    val passive_b_id: Int?,
    val passive_c_id: Int?,
    val passive_s_id: Int
)