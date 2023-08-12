package com.juan.fehome.DataBase.model

class Hero(
    private val idHeroes: Int,
    private val name: String,
    private val title: String,
    private val legendary: Int,
    private val legendaryElement: String?,
    private val legendaryBuff: String?,
    private val newHero: Int,
    private val seasonal: Int,
    private val seasonalType: String?,
    private val duo: Int,
    private val duoSkill: String?,
    private val harmonic: Int,
    private val harmonicSkill: String?,
    private val minRarity: Int,
    private val maxRarity: Int,
    private val weaponType: String,
    private val color: String,
    private val moveType: String,
    private val heroStatsId: Int,
    private val imageThumbnail: String,
    private val imageFull1: String,
    private val imageFull2: String?,
    private val imageFull3: String?,
    private val imageFull4: String?
) {
    override fun toString(): String {
        return "Hero(idHeroes=$idHeroes, name='$name', title='$title', legendary=$legendary, legendaryElement=$legendaryElement, legendaryBuff=$legendaryBuff, newHero=$newHero, seasonal=$seasonal, seasonalType=$seasonalType, duo=$duo, duoSkill=$duoSkill, harmonic=$harmonic, harmonicSkill=$harmonicSkill, minRarity=$minRarity, maxRarity=$maxRarity, weaponType='$weaponType', color='$color', moveType='$moveType', heroStatsId=$heroStatsId, imageThumbnail='$imageThumbnail', imageFull1='$imageFull1', imageFull2=$imageFull2, imageFull3=$imageFull3, imageFull4=$imageFull4)"
    }
}