package com.juan.fehome.screens

object HeroDao {
    val heroes = mapOf(
        // "hero" to mapOf("HP" to 0, "ATK" to 0, "SPD" to 0, "DEF" to 0, "RES" to 0, "LITTLE_IMG" to "img_hero_", "FULL_IMG" to "img_hero_")
        "Hero" to mapOf(
            "HP" to 0, "ATK" to 0, "SPD" to 0, "DEF" to 0, "RES" to 0,
            "LITTLE_IMG" to "img_roblox", "FULL_IMG" to "img_roblox"),
        "Hilda (Idle Maiden)" to mapOf(
            "HP" to 43, "ATK" to 37, "SPD" to 37, "DEF" to 28, "RES" to 23,
            "LITTLE_IMG" to "img_hero_hilda", "FULL_IMG" to "img_hero_hilda_full"),
        "Hilda (Deer's Two-Piece)" to mapOf(
            "HP" to 39, "ATK" to 37, "SPD" to 40, "DEF" to 20, "RES" to 25,
            "LITTLE_IMG" to "img_hero_hilda_deers_two_piece", "FULL_IMG" to "img_hero_hilda_deers_two_piece_full"),
        "Hilda (Holiday Layabout)" to mapOf(
            "HP" to 44, "ATK" to 39, "SPD" to 38, "DEF" to 37, "RES" to 26,
            "LITTLE_IMG" to "img_hero_hilda_holiday_layabout", "FULL_IMG" to "img_hero_hilda_holiday_layabout_full")
    )

    // Función para obtener la lista de nombres de héroes
    fun getHeroNames(): List<String> {
        return heroes.keys.toList()
    }

    // Función para obtener la información completa de un héroe específico
    fun getHeroInfo(heroName: String): Map<String, Any>? {
        return heroes[heroName]
    }
}