package com.juan.fehome.DataBase.service

import android.content.ContentValues
import android.util.Log
import com.juan.fehome.DataBase.SQLiteHelper

class PassiveService(private val fehomeDBHelper: SQLiteHelper) {
    fun InsertPassive(idPassive: Int, name: String, effect: String, hpBoost: Int?, atkBoost: Int?,
                      spdBoost: Int?, defBoost: Int?, resBoost: Int?, spCost: Int?, slot: String,
                      seal: Int, exclusive: Int, moveType: String, colorRestriction: String,
                      range: Int, healerSkill: Int): Long {

        val db = fehomeDBHelper.writableDatabase

        val values = ContentValues().apply {
            put("id_passive", idPassive)
            put("name", name)
            put("effect", effect)
            put("hp_boost", hpBoost)
            put("atk_boost", atkBoost)
            put("spd_boost", spdBoost)
            put("def_boost", defBoost)
            put("res_boost", resBoost)
            put("sp_cost", spCost)
            put("slot", slot)
            put("seal", seal)
            put("exclusive_", exclusive)
            put("move_type", moveType)
            put("color_restriction", colorRestriction)
            put("range", range)
            put("healer_skill", healerSkill)
        }

        var status: Long = 0

        try {
            status = db.insert("passives", null, values)
            Log.d("InsertPassive", "Insert passive has did successfully")
        }catch (e: Exception){
            Log.d("Error inserting passive", e.toString())
        }finally {
            db.close()
        }
        return status
    }
}