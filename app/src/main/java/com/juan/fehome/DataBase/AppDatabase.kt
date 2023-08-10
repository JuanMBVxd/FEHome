package com.juan.fehome.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.juan.fehome.DataBase.DAO.AssistsDao
import com.juan.fehome.DataBase.DAO.BuildBaseDao
import com.juan.fehome.DataBase.DAO.BuildsCustomsDao
import com.juan.fehome.DataBase.DAO.HeroStatsDao
import com.juan.fehome.DataBase.DAO.HeroesDao
import com.juan.fehome.DataBase.DAO.PassivesDao
import com.juan.fehome.DataBase.DAO.SpecialsDao
import com.juan.fehome.DataBase.DAO.WeaponEffectDao
import com.juan.fehome.DataBase.DAO.WeaponsDao
import com.juan.fehome.DataBase.entities.AssistEntity
import com.juan.fehome.DataBase.entities.BuildBaseEntity
import com.juan.fehome.DataBase.entities.BuildCustomEntity
import com.juan.fehome.DataBase.entities.HeroStatsEntity
import com.juan.fehome.DataBase.entities.HeroesEntity
import com.juan.fehome.DataBase.entities.PassiveEntity
import com.juan.fehome.DataBase.entities.SpecialEntity
import com.juan.fehome.DataBase.entities.WeaponEffectEntity
import com.juan.fehome.DataBase.entities.WeaponEntity

@Database(
    entities = [
        HeroesEntity::class,
        HeroStatsEntity::class,
        WeaponEffectEntity::class,
        WeaponEntity::class,
        AssistEntity::class,
        SpecialEntity::class,
        PassiveEntity::class,
        BuildBaseEntity::class,
        BuildCustomEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun heroesDao(): HeroesDao
    abstract fun heroStatsDao(): HeroStatsDao
    abstract fun weaponEffectDao(): WeaponEffectDao
    abstract fun weaponsDao(): WeaponsDao
    abstract fun assistsDao(): AssistsDao
    abstract fun specialsDao(): SpecialsDao
    abstract fun passivesDao(): PassivesDao
    abstract fun buildBaseDao(): BuildBaseDao
    abstract fun buildCustomDao(): BuildsCustomsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "fehome_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}