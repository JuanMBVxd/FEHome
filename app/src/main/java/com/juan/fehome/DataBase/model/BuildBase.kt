package com.juan.fehome.DataBase.model

class BuildBase(
    private var idBuildBase: Int,
    private var heroId: Int,
    private var weaponPrfId: Int,
    private var weaponNoPrfId: Int,
    private var assistId: Int,
    private var specialId: Int,
    private var passiveAId: Int,
    private var passiveBId: Int,
    private var passiveCId: Int
) {
    constructor(): this(
        0, 0, 0, 0, 0, 0, 0, 0, 0
    )

    fun setIdBuildBase(idBuildBase: Int) {
        this.idBuildBase = idBuildBase
    }

    fun setHeroId(heroId: Int) {
        this.heroId = heroId
    }

    fun setWeaponPrfId(weaponPrfId: Int) {
        this.weaponPrfId = weaponPrfId
    }

    fun setWeaponNoPrfId(weaponNoPrfId: Int) {
        this.weaponNoPrfId = weaponNoPrfId
    }

    fun setAssistId(assistId: Int) {
        this.assistId = assistId
    }

    fun setSpecialId(specialId: Int) {
        this.specialId = specialId
    }

    fun setPassiveAId(passiveAId: Int) {
        this.passiveAId = passiveAId
    }

    fun setPassiveBId(passiveBId: Int) {
        this.passiveBId = passiveBId
    }

    fun setPassiveCId(passiveCId: Int) {
        this.passiveCId = passiveCId
    }
    override fun toString(): String {
        return "BuildBase(idBuildBase=$idBuildBase, heroId=$heroId, weaponPrfId=$weaponPrfId, weaponNoPrfId=$weaponNoPrfId, assistId=$assistId, specialId=$specialId, passiveAId=$passiveAId, passiveBId=$passiveBId, passiveCId=$passiveCId)"
    }
}