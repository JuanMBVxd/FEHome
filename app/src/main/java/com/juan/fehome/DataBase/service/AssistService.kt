package com.juan.fehome.DataBase.service

import android.content.ContentValues
import android.util.Log
import com.juan.fehome.DataBase.SQLiteHelper

class AssistService(private val fehomeDBHelper: SQLiteHelper) {
    fun InsertAssist(idAssist: Int, name: String, effect: String, range: Int, spCost: Int?,
                     exclusive: Int, healerSkill: Int): Long {

        val db = fehomeDBHelper.writableDatabase

        val values = ContentValues().apply {
            put("id_assist", idAssist)
            put("name", name)
            put("effect", effect)
            put("range", range)
            put("sp_cost", spCost)
            put("exclusive_", exclusive)
            put("healer_skill", healerSkill)
        }

        var status: Long = 0

        try {
            status = db.insert("assists", null, values)
            Log.d("InsertAssist", "Insert assist has did successfully")
        }catch (e: Exception){
            Log.d("Error inserting assist", e.toString())
        }finally {
            db.close()
        }
        return status
    }
}