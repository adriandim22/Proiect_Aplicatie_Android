package com.cst.proiectaplicatieandroid.models.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("Teams")
data class TeamDBModel (
    @PrimaryKey
    val teamId: Int,
    @ColumnInfo(name = "echipa")
    val teamName: String,
    val coach: String
)