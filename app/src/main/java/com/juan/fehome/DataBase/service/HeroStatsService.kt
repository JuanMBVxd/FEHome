package com.juan.fehome.DataBase.service

import android.content.ContentValues
import android.database.Cursor
import android.util.Log
import com.juan.fehome.DataBase.SQLiteHelper
import com.juan.fehome.DataBase.model.HeroStats
import java.util.ArrayList

class HeroStatsService(private val fehomeDBHelper: SQLiteHelper) {
    fun InsertHeroStats(id_hero_stats: Int, hp_base: Int, atk_base: Int, spd_base: Int, def_base: Int,
                        res_base: Int, hp_boon: Int, atk_boon: Int, spd_boon: Int, def_boon: Int,
                        res_boon: Int, hp_bane: Int, atk_bane: Int, spd_bane: Int, def_bane:Int,
                        res_bane: Int): Long{

        // Get a writeable database instance

        val db = fehomeDBHelper.writableDatabase

        val heroStats = HeroStats(id_hero_stats, hp_base, atk_base, spd_base, def_base, res_base,
                                hp_boon, atk_boon, spd_boon, def_boon, res_boon,
                                hp_bane, atk_bane, spd_bane, def_bane, res_bane)

        // Create a ContentValues to store the heroStats data
        val values = ContentValues().apply {
            put("id_hero_stats", id_hero_stats)
            put("hp_base", hp_base)
            put("atk_base", atk_base)
            put("spd_base", spd_base)
            put("def_base", def_base)
            put("res_base", res_base)
            put("hp_boon", hp_boon)
            put("atk_boon", atk_boon)
            put("spd_boon", spd_boon)
            put("def_boon", def_boon)
            put("res_boon", res_boon)
            put("hp_bane", hp_bane)
            put("atk_bane", atk_bane)
            put("spd_bane", spd_bane)
            put("def_bane", def_bane)
            put("res_bane", res_bane)
        }

        var status: Long = 0

        try {
            // REALIZA LA OPERACION DE INSERTAR HERO STATS
            status = db.insert("hero_stats", null, values)
            println("InsertHeroStats has did successfully")

        }catch (e: Exception){
            e.printStackTrace()
            print("Error insert Hero Stats")
        }finally {
            db.close()
            /** Lo de abajo, cierra completamente la base de datos, se tendra que cambiar en un
             * futuro, debido a que como se haran muchas inserciones, si se cierra constantemente en
             * cada insercion, provocara un gran coste de rendimiento de la aplicacion
             * */
            fehomeDBHelper.close()
        }
        return status
    }

    fun SelectHeroStats(id: Int): HeroStats{
        val db = fehomeDBHelper.writableDatabase
        val heroStats = HeroStats()

        db.rawQuery("SELECT * FROM hero_stats WHERE id=?", null).use { cursor ->
            while (cursor.moveToFirst()){
                heroStats.setIdHeroStats(cursor.getInt(0))
                heroStats.setHpBase(cursor.getInt(1))
                heroStats.setAtkBase(cursor.getInt(2))
                heroStats.setSpdBase(cursor.getInt(3))
                heroStats.setDefBase(cursor.getInt(4))
                heroStats.setResBase(cursor.getInt(5))
                heroStats.setHpBoon(cursor.getInt(6))
                heroStats.setAtkBoon(cursor.getInt(7))
                heroStats.setSpdBoon(cursor.getInt(8))
                heroStats.setDefBoon(cursor.getInt(9))
                heroStats.setResBoon(cursor.getInt(10))
                heroStats.setHpBane(cursor.getInt(11))
                heroStats.setAtkBane(cursor.getInt(12))
                heroStats.setSpdBane(cursor.getInt(13))
                heroStats.setDefBane(cursor.getInt(14))
                heroStats.setResBane(cursor.getInt(15))
            }
        }
        return heroStats
    }

    fun UpgradeHeroStats(id_hero_stats: Int, hp_base: Int, atk_base: Int, spd_base: Int, def_base: Int,
                         res_base: Int, hp_boon: Int, atk_boon: Int, spd_boon: Int, def_boon: Int,
                         res_boon: Int, hp_bane: Int, atk_bane: Int, spd_bane: Int, def_bane:Int,
                         res_bane: Int): Int {
        // Get a writeable database instance
        val db = fehomeDBHelper.writableDatabase

        val values = ContentValues().apply {
            put("hp_base", hp_base)
            put("atk_base", atk_base)
            put("spd_base", spd_base)
            put("def_base", def_base)
            put("res_base", res_base)
            put("hp_boon", hp_boon)
            put("atk_boon", atk_boon)
            put("spd_boon", spd_boon)
            put("def_boon", def_boon)
            put("res_boon", res_boon)
            put("hp_bane", hp_bane)
            put("atk_bane", atk_bane)
            put("spd_bane", spd_bane)
            put("def_bane", def_bane)
            put("res_bane", res_bane)
        }
        var rowsAffected = 0

        try{
            // REALIZA LA OPERACION DE ACTUALIZAR PRODUCTO
            rowsAffected = db.update("hero_stats", values, "id_hero_stats=?", arrayOf(id_hero_stats.toString()))
            // Update successful, log the number of rows affected
            Log.d("Update_HeroStats", "HeroStats updated successfully. Rows affected: $rowsAffected")
        }catch (e: Exception){
            Log.d("Error updating heroStats", e.toString())
        }finally {
            db.close()
        }
        return  rowsAffected
    }

    fun DeleteHeroStats(
        id_hero_stats: Int
    ): Int{
        // Get a writeable database instance
        val db = fehomeDBHelper.writableDatabase

        var rowsDeleted = 0

        /** Apartir de aqui, es checar que en la tabla heroes, no haya ningun heroe relacionado*/
        return rowsDeleted
    }

    fun GetAllHeroStats(): List<HeroStats>{
        val heroStatsList: MutableList<HeroStats>  = mutableListOf()
        val db = fehomeDBHelper.readableDatabase

        db.rawQuery("SELECT * FROM hero_stats", null).use { cursor ->
            while (cursor.moveToNext()){
                val heroStats = HeroStats()
                heroStats.setIdHeroStats(cursor.getInt(0))
                heroStats.setHpBase(cursor.getInt(1))
                heroStats.setAtkBase(cursor.getInt(2))
                heroStats.setSpdBase(cursor.getInt(3))
                heroStats.setDefBase(cursor.getInt(4))
                heroStats.setResBase(cursor.getInt(5))
                heroStats.setHpBoon(cursor.getInt(6))
                heroStats.setAtkBoon(cursor.getInt(7))
                heroStats.setSpdBoon(cursor.getInt(8))
                heroStats.setDefBoon(cursor.getInt(9))
                heroStats.setResBoon(cursor.getInt(10))
                heroStats.setHpBane(cursor.getInt(11))
                heroStats.setAtkBane(cursor.getInt(12))
                heroStats.setSpdBane(cursor.getInt(13))
                heroStats.setDefBane(cursor.getInt(14))
                heroStats.setResBane(cursor.getInt(15))
                heroStatsList.add(heroStats)
            }
        }
        return heroStatsList
    }
}