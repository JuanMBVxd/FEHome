package com.juan.fehome.DataBase.model

class BuildBase(
    private val idBuildBase: Int,
    private val heroId: Int,
    private val weaponPrfId: Int,
    private val weaponNoPrfId: Int,
    private val assistId: Int,
    private val specialId: Int,
    private val passiveAId: Int,
    private val passiveBId: Int,
    private val passiveCId: Int
) {
    override fun toString(): String {
        return "BuildBase(idBuildBase=$idBuildBase, heroId=$heroId, weaponPrfId=$weaponPrfId, weaponNoPrfId=$weaponNoPrfId, assistId=$assistId, specialId=$specialId, passiveAId=$passiveAId, passiveBId=$passiveBId, passiveCId=$passiveCId)"
    }
}