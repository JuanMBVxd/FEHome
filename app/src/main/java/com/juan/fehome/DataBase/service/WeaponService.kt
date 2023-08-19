package com.juan.fehome.DataBase.service

import android.content.ContentValues
import android.util.Log
import com.juan.fehome.DataBase.SQLiteHelper

class WeaponService(private val fehomeDBHelper: SQLiteHelper) {
    fun InsertWeapon(idWeapon: Int, name: String, baseEffectId: Int, weaponType: String, colorWeapon: String,
                     might: Int, range: Int, spCost: Int?, exclusive: Int, refinablePrf: Int,
                     refinePrfEffectId: Int?, refinable: Int, refineEffectId: Int?): Long {

        val db = fehomeDBHelper.writableDatabase

        val values = ContentValues().apply {
            put("id_weapon", idWeapon)
            put("name", name)
            put("base_effect_id", baseEffectId)
            put("weapon_type", weaponType)
            put("color_weapon", colorWeapon)
            put("might", might)
            put("range", range)
            put("sp_cost", spCost)
            put("exclisive_", exclusive)
            put("refinable_prf", refinablePrf)
            put("refine_prf_effect_id", refinePrfEffectId)
            put("refinable", refinable)
            put("refine_effect_id", refineEffectId)
        }

        var status: Long = 0

        try {
            status = db.insert("weapons", null, values)
            Log.d("InsertWeapon", "Insert weapon has did successfully")
        }catch (e: Exception){
            Log.d("Error inserting weapon", e.toString())
        }finally {
            db.close()
        }
        return status
    }
}