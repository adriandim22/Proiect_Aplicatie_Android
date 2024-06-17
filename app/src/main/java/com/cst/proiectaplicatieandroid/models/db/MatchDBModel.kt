package com.cst.proiectaplicatieandroid.models.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MatchDBModel(
    @PrimaryKey
    val matchId: Int = 0,
    val date: String,
    val location: String
)