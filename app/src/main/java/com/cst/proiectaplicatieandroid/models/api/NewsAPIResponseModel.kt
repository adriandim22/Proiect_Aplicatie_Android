package com.cst.proiectaplicatieandroid.models.api

import com.google.gson.annotations.SerializedName

data class NewsAPIResponseModel(
    val id: Int,
    @SerializedName("title")
    val name: String,
    val category: String,
    val description: String,
)
