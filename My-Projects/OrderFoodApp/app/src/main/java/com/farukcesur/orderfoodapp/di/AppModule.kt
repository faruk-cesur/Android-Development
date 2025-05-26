package com.farukcesur.orderfoodapp.di

import com.farukcesur.orderfoodapp.data.remote.FoodService
import com.farukcesur.orderfoodapp.data.repository.FoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFoodService(): FoodService {
        return com.farukcesur.orderfoodapp.data.remote.ApiClient.foodService
    }

    @Provides
    @Singleton
    fun provideFoodRepository(foodService: FoodService): FoodRepository {
        return FoodRepository(foodService)
    }
}