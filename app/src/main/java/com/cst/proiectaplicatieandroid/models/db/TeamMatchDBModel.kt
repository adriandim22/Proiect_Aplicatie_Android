package com.cst.proiectaplicatieandroid.models.db

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = TeamDBModel::class,
            parentColumns = ["teamId"],
            childColumns = ["teamId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = MatchDBModel::class,
            parentColumns = ["matchId"],
            childColumns = ["matchId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TeamMatchDBModel(
    @PrimaryKey
    val teamMatchId: Int = 0,
    val teamId: Int,
    val matchId: Int,
    val goalsScored: Int
)