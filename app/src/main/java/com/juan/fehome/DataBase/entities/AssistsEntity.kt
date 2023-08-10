package com.juan.fehome.DataBase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "assists")
data class AssistEntity(
    @PrimaryKey(autoGenerate = true) val id_assist: Int = 0,
    val name: String,
    val effect: String,
    val range: Int,
    val sp_cost: Int?,
    val exclusive: Int,
    val healer_skill: Int
)