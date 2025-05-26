package com.farukcesur.orderfoodapp.data.repository

import com.farukcesur.orderfoodapp.data.model.Food
import com.farukcesur.orderfoodapp.data.remote.FoodService
import javax.inject.Inject

class FoodRepository @Inject constructor(
    private val foodService: FoodService
) {

    suspend fun getFoods(): List<Food> {
        val resp = foodService.getFoods()
        return if (resp.isSuccessful) {
            resp.body()?.yemekler ?: emptyList()
        } else {
            emptyList()
        }
    }
}