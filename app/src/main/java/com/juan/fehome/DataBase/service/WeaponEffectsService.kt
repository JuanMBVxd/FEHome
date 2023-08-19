package com.juan.fehome.DataBase.service

import android.content.ContentValues
import android.util.Log
import com.juan.fehome.DataBase.SQLiteHelper

class WeaponEffectsService(private val fehomeDBHelper: SQLiteHelper) {
    fun InsertWeaponEffect(idWeaponEffect: Int, effect: String, hpBoost: Int?, atkBoost: Int?, spdBoost: Int?,
                           defBoost: Int?, resBoost: Int?, imgIcon: String?): Long{

        val db = fehomeDBHelper.writableDatabase

        val values = ContentValues().apply {
            put("id_weapon_effect", idWeaponEffect)
            put("effect", effect)
            put("hp_boost", hpBoost)
            put("atk_boots", atkBoost)
            put("spd_boost", spdBoost)
            put("def_boost", defBoost)
            put("res_boost", resBoost)
            put("image_icon", imgIcon)
        }

        var status: Long = 0

        try {
            status = db.insert("weapon_effects", null, values)
            Log.d("InsertWeaponEffect", "Insert weapon effect has did successfully")
        }catch (e: Exception){
            Log.d("Error inserting weapon effect", e.toString())
        }finally {
            db.close()
        }
        return status
    }
}