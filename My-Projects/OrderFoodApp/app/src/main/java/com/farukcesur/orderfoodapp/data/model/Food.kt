package com.farukcesur.orderfoodapp.data.model

// Bu sınıf, her bir yemek objesini temsil ediyor. API'den birden fazla Food nesnesi gelecek.

data class Food(
    val yemek_id: String,
    val yemek_adi: String,
    val yemek_resim_adi: String,
    val yemek_fiyat: String
)