package com.juan.fehome.DataBase.service

import android.content.ContentValues
import android.util.Log
import com.juan.fehome.DataBase.SQLiteHelper
import com.juan.fehome.DataBase.model.Hero
import com.juan.fehome.DataBase.model.HeroStats
import kotlin.math.log

class HeroService(private val fehomeDBHelper: SQLiteHelper) {
    fun InsertHeroService(id_hero: Int, name: String, title: String, legendary: Int, legendaryElement: String?,
                          legendaryBuff: String?, newHero: Int, seasonal: Int, seasonalType: String?,
                          duo: Int, duoSkill: String?, harmonic: Int, harmonicSkill: String?, minRarity: Int,
                          maxRarity: Int, weaponType: String, color: String, moveType: String, maxDracoFlowers: Int,
                          heroStatsId: Int, imgMini: String, imgFull1: String, imgFull2: String, imgFull3: String,
                          imgFull4: String): Long{

        val db = fehomeDBHelper.writableDatabase

        val values = ContentValues().apply {
            put("id_heroes", id_hero)
            put("name", name)
            put("title", title)
            put("legendary", legendary)
            put("legendary_element", legendaryElement)
            put("legendary_buff", legendaryBuff)
            put("new_hero", newHero)
            put("seasonal", seasonal)
            put("seasonal_type", seasonalType)
            put("duo", duo)
            put("duo_skill", duoSkill)
            put("harmonic", harmonic)
            put("harmonic_skill", harmonicSkill)
            put("min_rarity", minRarity)
            put("max_rarity", maxRarity)
            put("weapon_type", weaponType)
            put("color", color)
            put("move_type", moveType)
            put("max_dracoflowers", maxDracoFlowers)
            put("hero_stats_id", heroStatsId)
            put("image_thumbnail", imgMini)
            put("image_full1", imgFull1)
            put("image_full2", imgFull2)
            put("image_full3", imgFull3)
            put("image_full4", imgFull4)
        }

        var status: Long = 0

        try {
            status = db.insert("heroes", null, values)
            Log.d("Insert_Hero","InsertHero has did succesfully")
        }catch (e: Exception){
            Log.d("Error inserting hero", e.toString())
        }finally {
            db.close()
        }
        return status
    }

    fun SelectHero(id: Int): Hero{
        val db = fehomeDBHelper.writableDatabase
        val hero = Hero()

        db.rawQuery("SELECT * FROM heroes WHERE id=?", null).use { cursor ->
            while (cursor.moveToFirst()){
                hero.setIdHeroes(cursor.getInt(0))
                hero.setName(cursor.getString(1))
                hero.setTitle(cursor.getString(2))
                hero.setLegendary(cursor.getInt(3))
                hero.setLegendaryElement(cursor.getString(4))
                hero.setLegendaryBuff(cursor.getString(5))
                hero.setNewHero(cursor.getInt(6))
                hero.setSeasonal(cursor.getInt(7))
                hero.setSeasonalType(cursor.getString(8))
                hero.setDuo(cursor.getInt(9))
                hero.setDuoSkill(cursor.getString(10))
                hero.setHarmonic(cursor.getInt(11))
                hero.setHarmonicSkill(cursor.getString(12))
                hero.setMinRarity(cursor.getInt(13))
                hero.setMaxRarity(cursor.getInt(14))
                hero.setWeaponType(cursor.getString(15))
                hero.setMaxDracoFlowers(cursor.getInt(16))
                hero.setHeroStatsId(cursor.getInt(17))
                hero.setImageThumbnail(cursor.getString(18))
                hero.setImageFull1(cursor.getString(19))
                hero.setImageFull2(cursor.getString(20))
                hero.setImageFull3(cursor.getString(21))
                hero.setImageFull4(cursor.getString(22))
            }
        }
        return hero
    }

    fun UpgradeHero(id_hero: Int, name: String, title: String, legendary: Int, legendaryElement: String?,
                    legendaryBuff: String?, newHero: Int, seasonal: Int, seasonalType: String?,
                    duo: Int, duoSkill: String?, harmonic: Int, harmonicSkill: String?, minRarity: Int,
                    maxRarity: Int, weaponType: String, color: String, moveType: String, maxDracoFlowers: Int,
                    heroStatsId: Int, imgMini: String, imgFull1: String, imgFull2: String, imgFull3: String,
                    imgFull4: String): Int{

        val db = fehomeDBHelper.writableDatabase

        val values = ContentValues().apply {
            put("id_heroes", id_hero)
            put("name", name)
            put("title", title)
            put("legendary", legendary)
            put("legendary_element", legendaryElement)
            put("legendary_buff", legendaryBuff)
            put("new_hero", newHero)
            put("seasonal", seasonal)
            put("seasonal_type", seasonalType)
            put("duo", duo)
            put("duo_skill", duoSkill)
            put("harmonic", harmonic)
            put("harmonic_skill", harmonicSkill)
            put("min_rarity", minRarity)
            put("max_rarity", maxRarity)
            put("weapon_type", weaponType)
            put("color", color)
            put("move_type", moveType)
            put("max_dracoflowers", maxDracoFlowers)
            put("hero_stats_id", heroStatsId)
            put("image_thumbnail", imgMini)
            put("image_full1", imgFull1)
            put("image_full2", imgFull2)
            put("image_full3", imgFull3)
            put("image_full4", imgFull4)
        }

        var rowsAffected = 0

        try {
            rowsAffected = db.update("heroes", values, "id_heroes=?", arrayOf(id_hero.toString()))
            Log.d("Update Hero", "Hero updated successfully. Rows affected: $rowsAffected")
        }catch (e: Exception){
            Log.d("Error updating hero", e.toString())
        }finally {
            db.close()
        }
        return rowsAffected
    }

    fun Select_Hero_HeroStats(hss: HeroStatsService, id: Int): List<Hero>{
        val heroList: MutableList<Hero>  = mutableListOf()
        val db = fehomeDBHelper.readableDatabase

        db.rawQuery("SELECT * FROM heroes WHERE hero_stats_id = ?", null).use { cursor ->
            while (cursor.moveToNext()){
                var hero = Hero()
                hero.setIdHeroes(cursor.getInt(0))
                hero.setName(cursor.getString(1))
                hero.setTitle(cursor.getString(2))
                hero.setLegendary(cursor.getInt(3))
                hero.setLegendaryElement(cursor.getString(4))
                hero.setLegendaryBuff(cursor.getString(5))
                hero.setNewHero(cursor.getInt(6))
                hero.setSeasonal(cursor.getInt(7))
                hero.setSeasonalType(cursor.getString(8))
                hero.setDuo(cursor.getInt(9))
                hero.setDuoSkill(cursor.getString(10))
                hero.setHarmonic(cursor.getInt(11))
                hero.setHarmonicSkill(cursor.getString(12))
                hero.setMinRarity(cursor.getInt(13))
                hero.setMaxRarity(cursor.getInt(14))
                hero.setWeaponType(cursor.getString(15))
                hero.setMaxDracoFlowers(cursor.getInt(16))
                hero.setHeroStatsId(cursor.getInt(17))
                hero.setImageThumbnail(cursor.getString(18))
                hero.setImageFull1(cursor.getString(19))
                hero.setImageFull2(cursor.getString(20))
                hero.setImageFull3(cursor.getString(21))
                hero.setImageFull4(cursor.getString(22))
                heroList.add(hero)
            }
        }
        return heroList
    }
}