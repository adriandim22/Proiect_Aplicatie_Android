package com.cst.proiectaplicatieandroid.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cst.proiectaplicatieandroid.models.db.MatchDBModel

@Dao
interface MatchDao {
    @Insert
    suspend fun insert(match: MatchDBModel)

    @Query("SELECT * FROM MatchDBModel")
    suspend fun getAllMatches(): List<MatchDBModel>
}