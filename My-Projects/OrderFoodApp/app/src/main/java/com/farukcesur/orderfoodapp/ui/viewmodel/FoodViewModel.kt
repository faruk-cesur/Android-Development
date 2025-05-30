package com.farukcesur.orderfoodapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farukcesur.orderfoodapp.data.model.CartItem
import com.farukcesur.orderfoodapp.data.model.Food
import com.farukcesur.orderfoodapp.data.repository.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    private val repository: FoodRepository
) : ViewModel() {

    private val _foods = MutableStateFlow<List<Food>>(emptyList())
    val foods: StateFlow<List<Food>> = _foods

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private var allFoods: List<Food> = emptyList()

    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems.asStateFlow()

    private val _favoriteFoods = MutableStateFlow<List<Food>>(emptyList())
    val favoriteFoods: StateFlow<List<Food>> = _favoriteFoods.asStateFlow()

    private val _totalPrice = MutableStateFlow(0)
    val totalPrice: StateFlow<Int> = _totalPrice.asStateFlow()

    fun fetchFoods() {
        viewModelScope.launch {
            try {
                allFoods = repository.getFoods()
                _foods.value = allFoods
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

    fun searchFoods(query: String) {
        viewModelScope.launch {
            _foods.value = if (query.isBlank()) {
                allFoods
            } else {
                allFoods.filter { food ->
                    food.yemek_adi.contains(query, ignoreCase = true)
                }
            }
        }
    }

    fun addToCart(food: Food, quantity: Int) {
        val currentList = _cartItems.value.toMutableList()
        val existingItem = currentList.find { it.yemek.yemek_id == food.yemek_id }

        if (existingItem != null) {
            existingItem.quantity += quantity
        } else {
            val newItem = CartItem(yemek = food, quantity = quantity)
            currentList.add(newItem)
        }

        _cartItems.value = currentList
        calculateTotal()
    }

    fun removeFromCart(food: Food) {
        val currentList = _cartItems.value.toMutableList()
        currentList.removeAll { it.yemek.yemek_id == food.yemek_id }

        _cartItems.value = currentList
        calculateTotal()
    }

    private fun calculateTotal() {
        val total = _cartItems.value.sumOf { it.yemek.yemek_fiyat.toInt() * it.quantity }
        _totalPrice.value = total
    }

    fun clearCart() {
        _cartItems.value = emptyList()
        _totalPrice.value = 0
    }

    fun addToFavorites(food: Food) {
        val currentList = _favoriteFoods.value.toMutableList()
        if (currentList.none { it.yemek_id == food.yemek_id }) {
            currentList.add(food)
            _favoriteFoods.value = currentList
        }
    }

    fun removeFromFavorites(food: Food) {
        val currentList = _favoriteFoods.value.toMutableList()
        currentList.removeAll { it.yemek_id == food.yemek_id }
        _favoriteFoods.value = currentList
    }

    fun isFavorite(food: Food): Boolean {
        return _favoriteFoods.value.contains(food)
    }
}