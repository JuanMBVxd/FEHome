package com.juan.fehome.DataBase.model

class Special(
    private val idSpecial: Int,
    private val name: String,
    private val effect: String,
    private val cooldown: Int,
    private val spCost: Int?,
    private val weaponTypeRestriction: String,
    private val exclusive: Int,
    private val healerSkill: Int
) {
    override fun toString(): String {
        return "Special(idSpecial=$idSpecial, name='$name', effect='$effect', cooldown=$cooldown, spCost=$spCost, weaponTypeRestriction='$weaponTypeRestriction', exclusive=$exclusive, healerSkill=$healerSkill)"
    }
}