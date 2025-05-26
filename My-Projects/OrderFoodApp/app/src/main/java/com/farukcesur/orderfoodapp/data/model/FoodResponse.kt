package com.farukcesur.orderfoodapp.data.model

// API'nin tüm yemek listesini ve başarı bilgisini sarar
data class FoodResponse(
    val yemekler: List<Food>,
    val success: Int
)