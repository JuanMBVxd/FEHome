package com.juan.fehome.DataBase.model

class Hero(
    private var idHeroes: Int,
    private var name: String,
    private var title: String,
    private var legendary: Int,
    private var legendaryElement: String?,
    private var legendaryBuff: String?,
    private var newHero: Int,
    private var seasonal: Int,
    private var seasonalType: String?,
    private var duo: Int,
    private var duoSkill: String?,
    private var harmonic: Int,
    private var harmonicSkill: String?,
    private var minRarity: Int,
    private var maxRarity: Int,
    private var weaponType: String,
    private var color: String,
    private var moveType: String,
    private var maxDracoFlowers: Int,
    private var heroStatsId: Int,
    private var imageThumbnail: String,
    private var imageFull1: String,
    private var imageFull2: String?,
    private var imageFull3: String?,
    private var imageFull4: String?
) {
    constructor() : this(
        0, "", "",0, "", "",0, 0,
        "", 0, "", 0, "",0, 0, "",
        "", "",0, 0, "","","","",""
    )

    fun setIdHeroes(idHeroes: Int) {
        this.idHeroes = idHeroes
    }

    fun setName(name: String) {
        this.name = name
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun setLegendary(legendary: Int) {
        this.legendary = legendary
    }

    fun setLegendaryElement(legendaryElement: String?) {
        this.legendaryElement = legendaryElement
    }

    fun setLegendaryBuff(legendaryBuff: String?) {
        this.legendaryBuff = legendaryBuff
    }

    fun setNewHero(newHero: Int) {
        this.newHero = newHero
    }

    fun setSeasonal(seasonal: Int) {
        this.seasonal = seasonal
    }

    fun setSeasonalType(seasonalType: String?) {
        this.seasonalType = seasonalType
    }

    fun setDuo(duo: Int) {
        this.duo = duo
    }

    fun setDuoSkill(duoSkill: String?) {
        this.duoSkill = duoSkill
    }

    fun setHarmonic(harmonic: Int) {
        this.harmonic = harmonic
    }

    fun setHarmonicSkill(harmonicSkill: String?) {
        this.harmonicSkill = harmonicSkill
    }

    fun setMinRarity(minRarity: Int) {
        this.minRarity = minRarity
    }

    fun setMaxRarity(maxRarity: Int) {
        this.maxRarity = maxRarity
    }

    fun setWeaponType(weaponType: String) {
        this.weaponType = weaponType
    }

    fun setColor(color: String) {
        this.color = color
    }

    fun setMoveType(moveType: String) {
        this.moveType = moveType
    }

    fun setMaxDracoFlowers(maxDracoFlowers: Int) {
        this.maxDracoFlowers = maxDracoFlowers
    }

    fun setHeroStatsId(heroStatsId: Int) {
        this.heroStatsId = heroStatsId
    }

    fun setImageThumbnail(imageThumbnail: String) {
        this.imageThumbnail = imageThumbnail
    }

    fun setImageFull1(imageFull1: String) {
        this.imageFull1 = imageFull1
    }

    fun setImageFull2(imageFull2: String?) {
        this.imageFull2 = imageFull2
    }

    fun setImageFull3(imageFull3: String?) {
        this.imageFull3 = imageFull3
    }

    fun setImageFull4(imageFull4: String?) {
        this.imageFull4 = imageFull4
    }



    override fun toString(): String {
        return "Hero(idHeroes=$idHeroes, name='$name', title='$title', legendary=$legendary, legendaryElement=$legendaryElement, legendaryBuff=$legendaryBuff, newHero=$newHero, seasonal=$seasonal, seasonalType=$seasonalType, duo=$duo, duoSkill=$duoSkill, harmonic=$harmonic, harmonicSkill=$harmonicSkill, minRarity=$minRarity, maxRarity=$maxRarity, weaponType='$weaponType', color='$color', moveType='$moveType', maxDracoFlowers= '$maxDracoFlowers', heroStatsId=$heroStatsId, imageThumbnail='$imageThumbnail', imageFull1='$imageFull1', imageFull2=$imageFull2, imageFull3=$imageFull3, imageFull4=$imageFull4)"
    }
}