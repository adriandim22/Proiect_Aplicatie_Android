package com.cst.proiectaplicatieandroid.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cst.proiectaplicatieandroid.models.db.TeamDBModel


@Dao
interface TeamDao {
    @Insert
    fun insert(team: TeamDBModel)

    @Insert
    fun insertAll(team: List<TeamDBModel>)

    @Query("SELECT * FROM Teams")
    suspend fun getAllTeams(): List<TeamDBModel>
}