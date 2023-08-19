package com.juan.fehome.DataBase.model

class Weapon(
    private var idWeapon: Int,
    private var name: String,
    private var baseEffectId: Int,
    private var weaponType: String,
    private var colorWeapon: String,
    private var might: Int,
    private var range: Int,
    private var spCost: Int?,
    private var exclusive: Int,
    private var refinablePrf: Int,
    private var refinePrfEffectId: Int?,
    private var refinable: Int,
    private var refineEffectId: Int?
) {
    constructor(): this(
        0, "", 0, "", "", 0, 0, null, 0, 0, null, 0, null
    )

    fun setIdWeapon(idWeapon: Int) {
        this.idWeapon = idWeapon
    }

    fun setName(name: String) {
        this.name = name
    }

    fun setBaseEffectId(baseEffectId: Int) {
        this.baseEffectId = baseEffectId
    }

    fun setWeaponType(weaponType: String) {
        this.weaponType = weaponType
    }

    fun setColorWeapon(colorWeapon: String) {
        this.colorWeapon = colorWeapon
    }

    fun setMight(might: Int) {
        this.might = might
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

    fun setRefinablePrf(refinablePrf: Int) {
        this.refinablePrf = refinablePrf
    }

    fun setRefinePrfEffectId(refinePrfEffectId: Int?) {
        this.refinePrfEffectId = refinePrfEffectId
    }

    fun setRefinable(refinable: Int) {
        this.refinable = refinable
    }

    fun setRefineEffectId(refineEffectId: Int?) {
        this.refineEffectId = refineEffectId
    }
    override fun toString(): String {
        return "Weapon(idWeapon=$idWeapon, name='$name', baseEffectId=$baseEffectId, weaponType='$weaponType', colorWeapon='$colorWeapon', might=$might, range=$range, spCost=$spCost, exclusive=$exclusive, refinablePrf=$refinablePrf, refinePrfEffectId=$refinePrfEffectId, refinable=$refinable, refineEffectId=$refineEffectId)"
    }
}