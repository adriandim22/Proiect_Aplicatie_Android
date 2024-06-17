package com.cst.proiectaplicatieandroid.data
import androidx.room.Database
import androidx.room.RoomDatabase
import com.cst.proiectaplicatieandroid.models.db.MatchDBModel
import com.cst.proiectaplicatieandroid.models.db.PlayerDBModel
import com.cst.proiectaplicatieandroid.models.db.TeamDBModel
import com.cst.proiectaplicatieandroid.models.db.TeamMatchDBModel

@Database(
    entities = [TeamDBModel::class, PlayerDBModel::class, MatchDBModel::class, TeamMatchDBModel::class],
    version = 1)

abstract class AppDatabase : RoomDatabase() {
    abstract fun teamDao(): TeamDao
    abstract fun playerDao(): PlayerDao
    abstract fun matchDao(): MatchDao
    abstract fun teamMatchDao(): TeamMatchDao
}