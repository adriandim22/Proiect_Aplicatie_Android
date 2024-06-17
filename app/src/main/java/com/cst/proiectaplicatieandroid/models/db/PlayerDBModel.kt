package com.cst.proiectaplicatieandroid.models.db

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = TeamDBModel::class,
        parentColumns = ["teamId"],
        childColumns = ["teamId"],
        onDelete = ForeignKey.CASCADE
    )]
)

data class PlayerDBModel(
    @PrimaryKey
    val playerId: Int = 0,
    val teamId: Int,
    val playerName: String,
    val position: String,
    val age: Int
)