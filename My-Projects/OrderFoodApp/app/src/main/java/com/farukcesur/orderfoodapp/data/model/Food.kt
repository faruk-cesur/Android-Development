package com.farukcesur.orderfoodapp.data.model
// Bu sınıf, her bir yemek objesini temsil ediyor. API'den birden fazla Food nesnesi gelecek.

data class Food(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrl: String
)