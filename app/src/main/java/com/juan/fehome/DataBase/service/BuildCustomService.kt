package com.juan.fehome.DataBase.service

import android.content.ContentValues
import android.util.Log
import com.juan.fehome.DataBase.SQLiteHelper

class BuildCustomService(private val fehomeDBHelper: SQLiteHelper) {
    fun InsertBuildCustom(idBuildCustom: Int, heroId: Int, merges: Int, dracoFlowers: Int, asset: String?,
                          ascendedAsset: String, flaw: String?, summonSupport: Int?, weapon_id: Int?,
                          assistId: Int?, specialId: Int?, passiveAId: Int?, passiveBId: Int?,
                          passiveCId: Int?, passiveSId: Int?): Long {

        val db = fehomeDBHelper.writableDatabase

        val values = ContentValues().apply {
            put("id_build_custom", idBuildCustom)
            put("hero_id", heroId)
            put("merges", merges)
            put("dracoflowers", dracoFlowers)
            put("asset", asset)
            put("ascended_asset", ascendedAsset)
            put("flaw", flaw)
            put("summon_support", summonSupport)
            put("weapon_id", weapon_id)
            put("assist_id", assistId)
            put("special_id", specialId)
            put("passive_a_id", passiveAId)
            put("passive_b_id", passiveBId)
            put("passive_c_id", passiveCId)
            put("passive_s_id", passiveSId)
        }

        var status: Long = 0

        try {
            status = db.insert("builds_customs", null, values)
            Log.d("InsertBuildCustom", "Insert build custom has did successfully")
        }catch (e: Exception){
            Log.d("Error inserting build custom", e.toString())
        }finally {
            db.close()
        }
        return status
    }
}