package com.juan.fehome.DataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context): SQLiteOpenHelper(context, "fehome.db", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        val tableHeroStats = "CREATE TABLE hero_stats "+
                "(id_hero_stats INTEGER NOT NULL,\n" +
                "  hp_base INTEGER NOT NULL,\n" +
                "  atk_base INTEGER NOT NULL,\n" +
                "  spd_base INTEGER NOT NULL,\n" +
                "  def_base INTEGER NOT NULL,\n" +
                "  res_base INTEGER NOT NULL,\n" +
                "  hp_boon INTEGER NOT NULL,\n" +
                "  atk_boon INTEGER NOT NULL,\n" +
                "  spd_boon INTEGER NOT NULL,\n" +
                "  def_boon INTEGER NOT NULL,\n" +
                "  res_boon INTEGER NOT NULL,\n" +
                "  hp_bane INTEGER NOT NULL,\n" +
                "  atk_bane INTEGER NOT NULL,\n" +
                "  spd_bane INTEGER NOT NULL,\n" +
                "  def_bane INTEGER NOT NULL,\n" +
                "  res_bane INTEGER NOT NULL,\n" +
                "  CONSTRAINT pk_stats PRIMARY KEY (id_hero_stats)" +
                ")"

        val tableWeaponEffects = "CREATE TABLE weapon_effects "+
                "(id_weapon_effect INTEGER NOT NULL,\n" +
                "  effect TEXT NOT NULL,\n" +
                "  hp_boost INTEGER,\n" +
                "  atk_boost INTEGER,\n" +
                "  spd_boost INTEGER,\n" +
                "  def_boost INTEGER,\n" +
                "  res_boost INTEGER,\n" +
                "  image_icon TEXT,\n" +
                "  CONSTRAINT pk_weapon_effects PRIMARY KEY (id_weapon_effect)" +
                ")"

        val tableAssists = "CREATE TABLE assists "+
                "(id_assist INTEGER NOT NULL,\n" +
                "  name TEXT NOT NULL,\n" +
                "  effect TEXT NOT NULL,\n" +
                "  range INTEGER NOT NULL,\n" +
                "  sp_cost INTEGER,\n" +
                "  exclusive_ INTEGER NOT NULL DEFAULT 0,\n" +
                "  healer_skill INTEGER NOT NULL DEFAULT 0,\n" +
                "  CONSTRAINT pk_assists PRIMARY KEY (id_assist)" +
                ")"

        val tableSpecials = "CREATE TABLE specials "+
                "(id_special INTEGER NOT NULL,\n" +
                "  name TEXT NOT NULL,\n" +
                "  effect TEXT NOT NULL,\n" +
                "  cooldown INTEGER NOT NULL,\n" +
                "  sp_cost INTEGER,\n" +
                "  weapon_type_restriction TEXT NOT NULL,\n" +
                "  exclusive_ INTEGER NOT NULL DEFAULT 0,\n" +
                "  healer_skill INTEGER NOT NULL DEFAULT 0,\n" +
                "  CONSTRAINT pk_specials PRIMARY KEY (id_special)" +
                ")"

        val tablePassives = "CREATE TABLE passives "+
                "(id_passive INTEGER NOT NULL,\n" +
                "  name TEXT NOT NULL,\n" +
                "  effect TEXT NOT NULL,\n" +
                "  hp_boost INTEGER,\n" +
                "  atk_boost INTEGER,\n" +
                "  spd_boost INTEGER,\n" +
                "  def_boost INTEGER,\n" +
                "  res_boost INTEGER,\n" +
                "  sp_cost INTEGER,\n" +
                "  slot TEXT NOT NULL,\n" +
                "  seal INTEGER NOT NULL,\n" +
                "  exclusive_ INTEGER DEFAULT 0,\n" +
                "  move_type TEXT NOT NULL,\n" +
                "  color_restriction TEXT NOT NULL,\n" +
                "  range INTEGER NOT NULL,\n" +
                "  healer_skill INTEGER DEFAULT 0,\n" +
                "  CONSTRAINT pk_passives PRIMARY KEY (id_passive)" +
                ")"

        val tableHeroes = "CREATE TABLE heroes "+
                "(id_heroes INTEGER NOT NULL,\n" +
                "  name TEXT NOT NULL,\n" +
                "  title TEXT NOT NULL,\n" +
                "  legendary INTEGER DEFAULT 0,\n" +
                "  legendary_element TEXT,\n" +
                "  legendary_buff TEXT,\n" +
                "  new_hero INTEGER NOT NULL DEFAULT 1,\n" +
                "  seasonal INTEGER NOT NULL DEFAULT 0,\n" +
                "  seasonal_type TEXT,\n" +
                "  duo INTEGER NOT NULL DEFAULT 0,\n" +
                "  duo_skill TEXT,\n" +
                "  harmonic INTEGER NOT NULL DEFAULT 0,\n" +
                "  harmonic_skill TEXT,\n" +
                "  min_rarity INTEGER NOT NULL DEFAULT 1,\n" +
                "  max_rarity INTEGER NOT NULL DEFAULT 5,\n" +
                "  weapon_type TEXT NOT NULL,\n" +
                "  color TEXT NOT NULL,\n" +
                "  move_type TEXT NOT NULL,\n" +
                "  max_dracoflowers INTEGER NOT NULL, \n" +
                "  hero_stats_id INTEGER NOT NULL,\n" +
                "  image_thumbnail TEXT NOT NULL,\n" +
                "  image_full1 TEXT NOT NULL,\n" +
                "  image_full2 TEXT,\n" +
                "  image_full3 TEXT,\n" +
                "  image_full4 TEXT,\n" +
                "  CONSTRAINT pk_heroes PRIMARY KEY (id_heroes),\n" +
                "  FOREIGN KEY (hero_stats_id) REFERENCES hero_stats(id_hero_stats)" +
                ")"

        val tableWeapons = "CREATE TABLE weapons "+
                "(id_weapon INTEGER NOT NULL, \n" +
                "  name TEXT NOT NULL,\n" +
                "  base_effect_id INTEGER NOT NULL,\n" +
                "  weapon_type TEXT NOT NULL,\n" +
                "  color_weapon TEXT NOT NULL,\n" +
                "  might INTEGER NOT NULL,\n" +
                "  range INTEGER NOT NULL,\n" +
                "  sp_cost INTEGER,\n" +
                "  exclusive_ INTEGER NOT NULL DEFAULT 0,\n" +
                "  refinable_prf INTEGER NOT NULL DEFAULT 0,\n" +
                "  refine_prf_effect_id INTEGER,\n" +
                "  refinable INTEGER  NOT NULL DEFAULT 0,\n" +
                "  refine_effect_id INTEGER,\n" +
                "  CONSTRAINT pk_weapons PRIMARY KEY (id_weapon),\n" +
                "  FOREIGN KEY (base_effect_id) REFERENCES effects(id_effect),\n" +
                "  FOREIGN KEY (refine_prf_effect_id) REFERENCES effects(id_effect),\n" +
                "  FOREIGN KEY (refine_effect_id) REFERENCES effects(id_effect)" +
                ")"

        val tableBuildBase = "CREATE TABLE build_base "+
                "(id_build_base INTEGER NOT NULL,\n" +
                "  hero_id INTEGER NOT NULL,\n" +
                "  weapon_prf_id INTEGER NOT NULL,\n" +
                "  weapon_no_prf_id INTEGER NOT NULL,\n" +
                "  assist_id INTEGER NOT NULL,\n" +
                "  special_id INTEGER NOT NULL,\n" +
                "  passive_a_id INTEGER NOT NULL,\n" +
                "  passive_b_id INTEGER NOT NULL,\n" +
                "  passive_c_id INTEGER NOT NULL,\n" +
                "  CONSTRAINT pk_id_build_base PRIMARY KEY (id_build_base),\n" +
                "  FOREIGN KEY (hero_id) REFERENCES heroes(id_heroes),\n" +
                "  FOREIGN KEY (weapon_prf_id) REFERENCES weapons(id_weapon),\n" +
                "  FOREIGN KEY (weapon_no_prf_id) REFERENCES weapons(id_weapn),\n" +
                "  FOREIGN KEY (assist_id) REFERENCES assists(id_assist),\n" +
                "  FOREIGN KEY (special_id) REFERENCES specials(id_special),\n" +
                "  FOREIGN KEY (passive_a_id) REFERENCES passives(id_passive),\n" +
                "  FOREIGN KEY (passive_b_id) REFERENCES passives(id_passive),\n" +
                "  FOREIGN KEY (passive_c_id) REFERENCES passives(id_passive)" +
                ")"

        val tableBuildsCustoms = "CREATE TABLE builds_customs "+
                "(id_build_custom INTEGER NOT NULL,\n" +
                "  hero_id INTEGER NOT NULL,\n" +
                "  merges INTEGER DEFAULT 0,\n" +
                "  dracoflowers INTEGER DEFAULT 0,\n" +
                "  asset TEXT,\n" +
                "  ascended_asset TEXT,\n" +
                "  flaw TEXT,\n" +
                "  summon_support INTEGER,\n" +
                "  weapon_id INTEGER,\n" +
                "  assist_id INTEGER,\n" +
                "  special_id INTEGER,\n" +
                "  passive_a_id INTEGER,\n" +
                "  passive_b_id INTEGER,\n" +
                "  passive_c_id INTEGER,\n" +
                "  passive_s_id INTEGER,\n" +
                "  CONSTRAINT pk_id_build_custom PRIMARY KEY (id_build_custom),\n" +
                "  FOREIGN KEY (hero_id) REFERENCES heroes(id_heroes),\n" +
                "  FOREIGN KEY (weapon_id) REFERENCES weapons(id_weapon),\n" +
                "  FOREIGN KEY (assist_id) REFERENCES assists(id_assist),\n" +
                "  FOREIGN KEY (special_id) REFERENCES specials(id_special),\n" +
                "  FOREIGN KEY (passive_a_id) REFERENCES passives(id_passive),\n" +
                "  FOREIGN KEY (passive_b_id) REFERENCES passives(id_passive),\n" +
                "  FOREIGN KEY (passive_c_id) REFERENCES passives(id_passive),\n" +
                "  FOREIGN KEY (passive_s_id) REFERENCES passives(id_passive)" +
                ")"

        // Para cada tabla
        db!!.execSQL(tableHeroStats)
        db!!.execSQL(tableWeaponEffects)
        db!!.execSQL(tableAssists)
        db!!.execSQL(tableSpecials)
        db!!.execSQL(tablePassives)
        db!!.execSQL(tableHeroes)
        db!!.execSQL(tableWeapons)
        db!!.execSQL(tableBuildBase)
        db!!.execSQL(tableBuildsCustoms)
        print("Tablas creadas")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersioon: Int) {
        val tableHeroStats = "DROP TABLE IF EXISTS hero_stats"
        val tableWeaponEffects = "DROP TABLE IF EXISTS weapon_effects"
        val tableAssists = "DROP TABLE IF EXISTS assists"
        val tableSpecials = "DROP TABLE IF EXISTS specials"
        val tablePassives = "DROP TABLE IF EXISTS passives"
        val tableHeroes = "DROP TABLE IF EXISTS heroes"
        val tableWeapons = "DROP TABLE IF EXISTS weapons"
        val tableBuildBase = "DROP TABLE IF EXISTS build_base"
        val tableBuildsCustoms = "DROP TABLE IF EXISTS builds_customs"

        db!!.execSQL(tableHeroStats)
        db!!.execSQL(tableWeaponEffects)
        db!!.execSQL(tableAssists)
        db!!.execSQL(tableSpecials)
        db!!.execSQL(tablePassives)
        db!!.execSQL(tableHeroes)
        db!!.execSQL(tableWeapons)
        db!!.execSQL(tableBuildBase)
        db!!.execSQL(tableBuildsCustoms)
        print("Se actualizaran las tablas")
        onCreate(db)
    }

}