package com.cst.proiectaplicatieandroid.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cst.proiectaplicatieandroid.models.db.PlayerDBModel

@Dao
interface PlayerDao {
    @Insert
    suspend fun insert(player: PlayerDBModel)

    @Query("SELECT * FROM PlayerDBModel WHERE teamId = :teamId")
    suspend fun getPlayersForTeam(teamId: Int): List<PlayerDBModel>
}