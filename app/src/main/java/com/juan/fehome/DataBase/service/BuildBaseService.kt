package com.juan.fehome.DataBase.service

import android.content.ContentValues
import android.util.Log
import com.juan.fehome.DataBase.SQLiteHelper

class BuildBaseService(private val fehomeDBHelper: SQLiteHelper) {
    fun InsertBuildBase(idBuildBase: Int, heroId: Int, weaponPrfId: Int?, weaponNoPrfId: Int, assistId: Int,
                        specialId: Int?, passiveAId: Int?, passiveBId: Int?, passiveCId: Int?): Long {

        val db = fehomeDBHelper.writableDatabase

        val values = ContentValues().apply {
            put("id_build_base", idBuildBase)
            put("hero_id", heroId)
            put("weapon_prf_id", weaponPrfId)
            put("weapon_no_prf_id", weaponNoPrfId)
            put("assist_id", assistId)
            put("special_id", specialId)
            put("passive_a_id", passiveAId)
            put("passive_b_id", passiveBId)
            put("passive_c_id", passiveCId)
        }

        var status: Long = 0

        try {
            status = db.insert("build_base", null, values)
            Log.d("InsertBuildBase", "Insert build base has did successfully")
        }catch (e: Exception){
            Log.d("Error inserting build base", e.toString())
        }finally {
            db.close()
        }
        return status
    }
}