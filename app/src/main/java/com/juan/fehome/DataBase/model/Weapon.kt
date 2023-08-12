package com.juan.fehome.DataBase.model

class Weapon(
    private val idWeapon: Int,
    private val name: String,
    private val baseEffectId: Int,
    private val weaponType: String,
    private val colorWeapon: String,
    private val might: Int,
    private val range: Int,
    private val spCost: Int?,
    private val exclusive: Int,
    private val refinablePrf: Int,
    private val refinePrfEffectId: Int?,
    private val refinable: Int,
    private val refineEffectId: Int?
) {
    override fun toString(): String {
        return "Weapon(idWeapon=$idWeapon, name='$name', baseEffectId=$baseEffectId, weaponType='$weaponType', colorWeapon='$colorWeapon', might=$might, range=$range, spCost=$spCost, exclusive=$exclusive, refinablePrf=$refinablePrf, refinePrfEffectId=$refinePrfEffectId, refinable=$refinable, refineEffectId=$refineEffectId)"
    }
}