package com.juan.fehome.DataBase.model

class WeaponEffects(
    private var idWeaponEffect: Int,
    private var effect: String,
    private var hpBoost: Int?,
    private var atkBoost: Int?,
    private var spdBoost: Int?,
    private var defBoost: Int?,
    private var resBoost: Int?,
    private var imageIcon: String?
) {
    constructor() : this(0, "", null, null, null, null, null, null)

    fun getIdWeaponEffect(): Int {
        return idWeaponEffect
    }

    fun setIdWeaponEffect(id: Int) {
        idWeaponEffect = id
    }

    fun getEffect(): String {
        return effect
    }

    fun setEffect(newEffect: String) {
        effect = newEffect
    }

    fun getHpBoost(): Int? {
        return hpBoost
    }

    fun setHpBoost(boost: Int?) {
        hpBoost = boost
    }

    fun getAtkBoost(): Int? {
        return atkBoost
    }

    fun setAtkBoost(boost: Int?) {
        atkBoost = boost
    }

    fun getSpdBoost(): Int? {
        return spdBoost
    }

    fun setSpdBoost(boost: Int?) {
        spdBoost = boost
    }

    fun getDefBoost(): Int? {
        return defBoost
    }

    fun setDefBoost(boost: Int?) {
        defBoost = boost
    }

    fun getResBoost(): Int? {
        return resBoost
    }

    fun setResBoost(boost: Int?) {
        resBoost = boost
    }

    fun getImageIcon(): String? {
        return imageIcon
    }

    fun setImageIcon(icon: String?) {
        imageIcon = icon
    }

    override fun toString(): String {
        return "WeaponEffects(idWeaponEffect=$idWeaponEffect, effect='$effect', hpBoost=$hpBoost, atkBoost=$atkBoost, spdBoost=$spdBoost, defBoost=$defBoost, resBoost=$resBoost, imageIcon=$imageIcon)"
    }
}