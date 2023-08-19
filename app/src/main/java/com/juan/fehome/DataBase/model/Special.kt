package com.juan.fehome.DataBase.model

class Special(
    private var idSpecial: Int,
    private var name: String,
    private var effect: String,
    private var cooldown: Int,
    private var spCost: Int?,
    private var weaponTypeRestriction: String,
    private var exclusive: Int,
    private var healerSkill: Int
) {
    constructor(): this(
        0, "", "", 0, null, "", 0, 0
    )

    fun setIdSpecial(idSpecial: Int) {
        this.idSpecial = idSpecial
    }

    fun setName(name: String) {
        this.name = name
    }

    fun setEffect(effect: String) {
        this.effect = effect
    }

    fun setCooldown(cooldown: Int) {
        this.cooldown = cooldown
    }

    fun setSpCost(spCost: Int?) {
        this.spCost = spCost
    }

    fun setWeaponTypeRestriction(weaponTypeRestriction: String) {
        this.weaponTypeRestriction = weaponTypeRestriction
    }

    fun setExclusive(exclusive: Int) {
        this.exclusive = exclusive
    }

    fun setHealerSkill(healerSkill: Int) {
        this.healerSkill = healerSkill
    }
    override fun toString(): String {
        return "Special(idSpecial=$idSpecial, name='$name', effect='$effect', cooldown=$cooldown, spCost=$spCost, weaponTypeRestriction='$weaponTypeRestriction', exclusive=$exclusive, healerSkill=$healerSkill)"
    }
}