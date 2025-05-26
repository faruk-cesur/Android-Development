package com.farukcesur.orderfoodapp.data.remote

import com.farukcesur.orderfoodapp.data.model.FoodResponse
import retrofit2.Response
import retrofit2.http.GET

interface FoodService {

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getFoods(): Response<FoodResponse>
}