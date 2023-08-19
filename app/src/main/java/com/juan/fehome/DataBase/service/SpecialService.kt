package com.juan.fehome.DataBase.service

import android.content.ContentValues
import android.util.Log
import com.juan.fehome.DataBase.SQLiteHelper

class SpecialService(private val fehomeDBHelper: SQLiteHelper){
    fun InsertSpecial(idSpecial: Int, name: String, effect: String, cooldown: Int, spCost: Int?,
                      weaponTypeRestriction: String, exclusive: Int, healerSkill: Int): Long {

        val db = fehomeDBHelper.writableDatabase

        val values = ContentValues().apply {
            put("id_special", idSpecial)
            put("name", name)
            put("effect", effect)
            put("cooldown", cooldown)
            put("sp_cost", spCost)
            put("weapon_type_restriction", weaponTypeRestriction)
            put("exclusive_", exclusive)
            put("healer_skill", healerSkill)
        }

        var status: Long = 0

        try {
            status = db.insert("specials", null, values)
            Log.d("InsertSpecial", "Insert special has did successfully")
        }catch (e: Exception){
            Log.d("Error inserting special", e.toString())
        }finally {
            db.close()
        }
        return status
    }
}