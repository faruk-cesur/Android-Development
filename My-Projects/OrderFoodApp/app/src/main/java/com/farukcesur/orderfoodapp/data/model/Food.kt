package com.farukcesur.orderfoodapp.data.model

// API'den gelen tek bir yemeği temsil eder
data class Food(
    val yemek_id: String,
    val yemek_adi: String,
    val yemek_resim_adi: String,
    val yemek_fiyat: String
)