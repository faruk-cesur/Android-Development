package com.farukcesur.orderfoodapp.data.remote

import com.farukcesur.orderfoodapp.data.model.Food
import com.farukcesur.orderfoodapp.data.model.FoodResponse
import retrofit2.Response
import retrofit2.http.GET

// @GET("foods") → Sunucudan GET isteğiyle veri alır.
// suspend → Coroutine destekli çalışır. (ViewModel'de kullanacağız.)

interface FoodService {

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getFoods(): Response<FoodResponse>
}
