package com.juan.fehome.DataBase.model

class BuildCustom(
    private var idBuildCustom: Int,
    private var heroId: Int,
    private var merges: Int,
    private var dracoflowers: Int,
    private var asset: String?,
    private var ascendedAsset: String?,
    private var flaw: String?,
    private var summonSupport: Int?,
    private var weaponId: Int?,
    private var assistId: Int?,
    private var specialId: Int?,
    private var passiveAId: Int?,
    private var passiveBId: Int?,
    private var passiveCId: Int?,
    private var passiveSId: Int?
) {
    constructor(): this(
        0, 0, 0, 0, null, null, null, null, null, null, null, null, null, null, null,
    )

    fun setIdBuildCustom(idBuildCustom: Int) {
        this.idBuildCustom = idBuildCustom
    }

    fun setHeroId(heroId: Int) {
        this.heroId = heroId
    }

    fun setMerges(merges: Int) {
        this.merges = merges
    }

    fun setDracoflowers(dracoflowers: Int) {
        this.dracoflowers = dracoflowers
    }

    fun setAsset(asset: String?) {
        this.asset = asset
    }

    fun setAscendedAsset(ascendedAsset: String?) {
        this.ascendedAsset = ascendedAsset
    }

    fun setFlaw(flaw: String?) {
        this.flaw = flaw
    }

    fun setSummonSupport(summonSupport: Int?) {
        this.summonSupport = summonSupport
    }

    fun setWeaponId(weaponId: Int?) {
        this.weaponId = weaponId
    }

    fun setAssistId(assistId: Int?) {
        this.assistId = assistId
    }

    fun setSpecialId(specialId: Int?) {
        this.specialId = specialId
    }

    fun setPassiveAId(passiveAId: Int?) {
        this.passiveAId = passiveAId
    }

    fun setPassiveBId(passiveBId: Int?) {
        this.passiveBId = passiveBId
    }

    fun setPassiveCId(passiveCId: Int?) {
        this.passiveCId = passiveCId
    }

    fun setPassiveSId(passiveSId: Int?) {
        this.passiveSId = passiveSId
    }
    override fun toString(): String {
        return "BuildCustom(idBuildCustom=$idBuildCustom, heroId=$heroId, merges=$merges, dracoflowers=$dracoflowers, asset=$asset, ascendedAsset=$ascendedAsset, flaw=$flaw, summonSupport=$summonSupport, weaponId=$weaponId, assistId=$assistId, specialId=$specialId, passiveAId=$passiveAId, passiveBId=$passiveBId, passiveCId=$passiveCId, passiveSId=$passiveSId)"
    }
}




