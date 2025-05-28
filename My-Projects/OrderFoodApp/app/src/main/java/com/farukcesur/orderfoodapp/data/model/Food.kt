package com.farukcesur.orderfoodapp.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

// API'den gelen tek bir yemeği temsil eder
data class Food(
    @SerializedName("yemek_id") val yemek_id: Int,
    @SerializedName("yemek_adi") val yemek_adi: String,
    @SerializedName("yemek_resim_adi") val yemek_resim_adi: String,
    @SerializedName("yemek_fiyat") val yemek_fiyat: String
) : Serializable
