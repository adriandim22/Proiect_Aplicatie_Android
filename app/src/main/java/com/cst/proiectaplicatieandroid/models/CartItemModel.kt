package com.cst.proiectaplicatieandroid.models

enum class CartItemType(val key: Int) {
    NEWS(0),
    NEWS_CATEGORY(1)
}


sealed class CartItemModel(
    val type: CartItemType
)