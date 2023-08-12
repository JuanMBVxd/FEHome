package com.juan.fehome.DataBase

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase

class DataSeeder(private val db: SQLiteDatabase) {

    fun seedHeroStats() {
        // Insert hero stats data
        val query = "SELECT COUNT(*) FROM hero_stats"
        val cursor = db.rawQuery(query, null)
        cursor.moveToFirst()
        val rowCount = cursor.getInt(0)
        cursor.close()

        if(rowCount == 0){
            val values = ContentValues().apply {
                // Set values for each column
                put("hp_base", 50)
                put("atk_base", 40)
                // ... and so on for other columns
            }
            db.insert("hero_stats", null, values)
        }

    }

    fun seedHero() {
        // Insert weapon effects data
        // Similar to seedHeroStats but for weapon_effects table
    }

    // Define similar methods for other tables
}
