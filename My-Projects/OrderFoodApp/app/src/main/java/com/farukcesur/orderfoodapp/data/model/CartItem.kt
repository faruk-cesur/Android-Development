package com.farukcesur.orderfoodapp.data.model

data class CartItem(
    val yemek: Food,
    var quantity: Int = 1
)