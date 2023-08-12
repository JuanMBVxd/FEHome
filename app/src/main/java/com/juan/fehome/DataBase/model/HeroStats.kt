package com.juan.fehome.DataBase.model

class HeroStats(
    private var idHeroStats: Int,
    private var hpBase: Int,
    private var atkBase: Int,
    private var spdBase: Int,
    private var defBase: Int,
    private var resBase: Int,
    private var hpBoon: Int,
    private var atkBoon: Int,
    private var spdBoon: Int,
    private var defBoon: Int,
    private var resBoon: Int,
    private var hpBane: Int,
    private var atkBane: Int,
    private var spdBane: Int,
    private var defBane: Int,
    private var resBane: Int
) {
    // Constructor vacío
    constructor() : this(
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    )

    // Constructor con parámetros
    constructor(
        idHeroStats: Int,
        hpBase: Int,
        atkBase: Int,
        spdBase: Int,
        defBase: Int,
        resBase: Int,
        hpBoon: Int,
        atkBoon: Int,
        spdBoon: Int,
        defBoon: Int,
        resBoon: Int,
        hpBane: Int,
        atkBane: Int,
        spdBane: Int,
        defBane: Int,
        resBane: Int,
        fromParameters: Boolean
    ) : this(
        idHeroStats, hpBase, atkBase, spdBase, defBase, resBase,
        hpBoon, atkBoon, spdBoon, defBoon, resBoon,
        hpBane, atkBane, spdBane, defBane, resBane
    )

    fun getIdHeroStats(): Int { return idHeroStats }

    fun setIdHeroStats(id: Int) { idHeroStats = id }

    fun getHpBase(): Int { return hpBase }

    fun setHpBase(hp: Int) { hpBase = hp }

    fun getAtkBase(): Int { return atkBase }

    fun setAtkBase(atk: Int) { atkBase = atk }

    fun getSpdBase(): Int { return spdBase }

    fun setSpdBase(spd: Int) { spdBase = spd }

    fun getDefBase(): Int { return defBase }

    fun setDefBase(def: Int) { defBase = def }

    fun getResBase(): Int { return resBase }

    fun setResBase(res: Int) { resBase = res }

    fun getHpBoon(): Int { return hpBoon }

    fun setHpBoon(hp: Int) { hpBoon = hp }

    fun getAtkBoon(): Int { return atkBoon }

    fun setAtkBoon(atk: Int) { atkBoon = atk }

    fun getSpdBoon(): Int { return spdBoon }

    fun setSpdBoon(spd: Int) { spdBoon = spd }

    fun getDefBoon(): Int { return defBoon }

    fun setDefBoon(def: Int) { defBoon = def }

    fun getResBoon(): Int { return resBoon }

    fun setResBoon(res: Int) { resBoon = res }

    fun getHpBane(): Int { return hpBane }

    fun setHpBane(hp: Int) { hpBane = hp }

    fun getAtkBane(): Int { return atkBane }

    fun setAtkBane(atk: Int) { atkBane = atk }

    fun getSpdBane(): Int { return spdBane }

    fun setSpdBane(spd: Int) { spdBane = spd }

    fun getDefBane(): Int { return defBane }

    fun setDefBane(def: Int) { defBane = def }

    fun getResBane(): Int { return resBane }

    fun setResBane(res: Int) { resBane = res }

    override fun toString(): String {
        return "HeroStats(idHeroStats=$idHeroStats, hpBase=$hpBase, atkBase=$atkBase, spdBase=$spdBase, defBase=$defBase, resBase=$resBase, hpBoon=$hpBoon, atkBoon=$atkBoon, spdBoon=$spdBoon, defBoon=$defBoon, resBoon=$resBoon, hpBane=$hpBane, atkBane=$atkBane, spdBane=$spdBane, defBane=$defBane, resBane=$resBane)"
    }
}