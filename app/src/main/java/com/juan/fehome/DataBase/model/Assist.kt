package com.juan.fehome.DataBase.model

class Assist(
    private val idAssist: Int,
    private val name: String,
    private val effect: String,
    private val range: Int,
    private val spCost: Int?,
    private val exclusive: Int,
    private val healerSkill: Int
) {
    override fun toString(): String {
        return "Assist(idAssist=$idAssist, name='$name', effect='$effect', range=$range, spCost=$spCost, exclusive=$exclusive, healerSkill=$healerSkill)"
    }
}