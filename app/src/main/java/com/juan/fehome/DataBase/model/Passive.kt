package com.juan.fehome.DataBase.model

class Passive(
    private var idPassive: Int,
    private var name: String,
    private var effect: String,
    private var hpBoost: Int?,
    private var atkBoost: Int?,
    private var spdBoost: Int?,
    private var defBoost: Int?,
    private var resBoost: Int?,
    private var spCost: Int?,
    private var slot: String,
    private var seal: Int,
    private var exclusive: Int,
    private var moveType: String,
    private var colorRestriction: String,
    private var range: Int,
    private var healerSkill: Int
) {
    constructor(): this(
        0, "", "", null, null, null, null, null, null, "", 0, 0, "", "", 0, 0
    )

    fun setIdPassive(idPassive: Int) {
        this.idPassive = idPassive
    }

    fun setName(name: String) {
        this.name = name
    }

    fun setEffect(effect: String) {
        this.effect = effect
    }

    fun setHpBoost(hpBoost: Int?) {
        this.hpBoost = hpBoost
    }

    fun setAtkBoost(atkBoost: Int?) {
        this.atkBoost = atkBoost
    }

    fun setSpdBoost(spdBoost: Int?) {
        this.spdBoost = spdBoost
    }

    fun setDefBoost(defBoost: Int?) {
        this.defBoost = defBoost
    }

    fun setResBoost(resBoost: Int?) {
        this.resBoost = resBoost
    }

    fun setSpCost(spCost: Int?) {
        this.spCost = spCost
    }

    fun setSlot(slot: String) {
        this.slot = slot
    }

    fun setSeal(seal: Int) {
        this.seal = seal
    }

    fun setExclusive(exclusive: Int) {
        this.exclusive = exclusive
    }

    fun setMoveType(moveType: String) {
        this.moveType = moveType
    }

    fun setColorRestriction(colorRestriction: String) {
        this.colorRestriction = colorRestriction
    }

    fun setRange(range: Int) {
        this.range = range
    }

    fun setHealerSkill(healerSkill: Int) {
        this.healerSkill = healerSkill
    }
    override fun toString(): String {
        return "Passive(idPassive=$idPassive, name='$name', effect='$effect', hpBoost=$hpBoost, atkBoost=$atkBoost, spdBoost=$spdBoost, defBoost=$defBoost, resBoost=$resBoost, spCost=$spCost, slot='$slot', seal=$seal, exclusive=$exclusive, moveType='$moveType', colorRestriction='$colorRestriction', range=$range, healerSkill=$healerSkill)"
    }
}