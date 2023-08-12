package com.juan.fehome.DataBase.model

class BuildCustom(
    private val idBuildCustom: Int,
    private val heroId: Int,
    private val merges: Int,
    private val dracoflowers: Int,
    private val asset: String?,
    private val ascendedAsset: String?,
    private val flaw: String?,
    private val summonSupport: Int?,
    private val weaponId: Int?,
    private val assistId: Int?,
    private val specialId: Int?,
    private val passiveAId: Int?,
    private val passiveBId: Int?,
    private val passiveCId: Int?,
    private val passiveSId: Int?
) {
    override fun toString(): String {
        return "BuildCustom(idBuildCustom=$idBuildCustom, heroId=$heroId, merges=$merges, dracoflowers=$dracoflowers, asset=$asset, ascendedAsset=$ascendedAsset, flaw=$flaw, summonSupport=$summonSupport, weaponId=$weaponId, assistId=$assistId, specialId=$specialId, passiveAId=$passiveAId, passiveBId=$passiveBId, passiveCId=$passiveCId, passiveSId=$passiveSId)"
    }
}




