package com.juan.fehome.DataBase.model

class Passive(
    private val idPassive: Int,
    private val name: String,
    private val effect: String,
    private val hpBoost: Int?,
    private val atkBoost: Int?,
    private val spdBoost: Int?,
    private val defBoost: Int?,
    private val resBoost: Int?,
    private val spCost: Int?,
    private val slot: String,
    private val seal: Int,
    private val exclusive: Int,
    private val moveType: String,
    private val colorRestriction: String,
    private val range: Int,
    private val healerSkill: Int
) {
    override fun toString(): String {
        return "Passive(idPassive=$idPassive, name='$name', effect='$effect', hpBoost=$hpBoost, atkBoost=$atkBoost, spdBoost=$spdBoost, defBoost=$defBoost, resBoost=$resBoost, spCost=$spCost, slot='$slot', seal=$seal, exclusive=$exclusive, moveType='$moveType', colorRestriction='$colorRestriction', range=$range, healerSkill=$healerSkill)"
    }
}