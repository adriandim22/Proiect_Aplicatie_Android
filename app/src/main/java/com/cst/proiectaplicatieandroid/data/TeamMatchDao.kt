package com.cst.proiectaplicatieandroid.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cst.proiectaplicatieandroid.models.db.TeamMatchDBModel

@Dao
interface TeamMatchDao {
    @Insert
    suspend fun insert(teamMatch: TeamMatchDBModel)

    @Query("SELECT * FROM TeamMatchDBModel WHERE matchId = :matchId")
    suspend fun getTeamsForMatch(matchId: Int): List<TeamMatchDBModel>
}