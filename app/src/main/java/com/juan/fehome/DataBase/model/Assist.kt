package com.juan.fehome.DataBase.model

class Assist(
    private var idAssist: Int,
    private var name: String,
    private var effect: String,
    private var range: Int,
    private var spCost: Int?,
    private var exclusive: Int,
    private var healerSkill: Int
) {
    constructor(): this (
        0, "", "", 0, 0, 0, 0
    )

    fun setIdAssist(idAssist: Int) {
        this.idAssist = idAssist
    }

    fun setName(name: String) {
        this.name = name
    }

    fun setEffect(effect: String) {
        this.effect = effect
    }

    fun setRange(range: Int) {
        this.range = range
    }

    fun setSpCost(spCost: Int?) {
        this.spCost = spCost
    }

    fun setExclusive(exclusive: Int) {
        this.exclusive = exclusive
    }

    fun setHealerSkill(healerSkill: Int) {
        this.healerSkill = healerSkill
    }
    override fun toString(): String {
        return "Assist(idAssist=$idAssist, name='$name', effect='$effect', range=$range, spCost=$spCost, exclusive=$exclusive, healerSkill=$healerSkill)"
    }
}