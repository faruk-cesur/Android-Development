package com.farukcesur.orderfoodapp.data.repository

import com.farukcesur.orderfoodapp.data.model.Food
import com.farukcesur.orderfoodapp.data.remote.FoodService
import javax.inject.Inject

class FoodRepository @Inject constructor(
    private val foodService: FoodService
) {

    suspend fun getFoods(): List<Food> {
        val response = foodService.getFoods()
        return if (response.isSuccessful) {
            response.body()?.yemekler ?: emptyList()
        } else {
            emptyList()
        }
    }
}