package com.farukcesur.orderfoodapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farukcesur.orderfoodapp.data.model.Food
import com.farukcesur.orderfoodapp.data.repository.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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

    fun fetchFoods() {
        viewModelScope.launch {
            try {
                _foods.value = repository.getFoods()
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

    fun searchFoods(query: String) {
        viewModelScope.launch {
            val all = repository.getFoods()
            _foods.value = all.filter { it.yemek_adi.contains(query, ignoreCase = true) }
        }
    }
}