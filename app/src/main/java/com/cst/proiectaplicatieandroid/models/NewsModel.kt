package com.cst.proiectaplicatieandroid.models

import android.content.ClipDescription

data class NewsModel(
    val name: String,
    val description: String
): CartItemModel(
    type = CartItemType.NEWS
)