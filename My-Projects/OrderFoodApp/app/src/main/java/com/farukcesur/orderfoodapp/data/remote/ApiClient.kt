package com.farukcesur.orderfoodapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// by lazy → Yalnızca ihtiyaç duyulduğunda oluşturulur. Uygulama açıldığında boş yere belleği yormaz.

object ApiClient {

    private const val BASE_URL = "http://kasimadalan.pe.hu/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // JSON parser
            .build()
    }

    val foodService: FoodService by lazy {
        retrofit.create(FoodService::class.java)
    }
}
