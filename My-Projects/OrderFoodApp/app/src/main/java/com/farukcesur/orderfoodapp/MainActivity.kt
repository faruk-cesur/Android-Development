package com.farukcesur.orderfoodapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.farukcesur.orderfoodapp.databinding.ActivityMainBinding
import com.farukcesur.orderfoodapp.ui.adapter.FoodAdapter
import com.farukcesur.orderfoodapp.ui.viewmodel.FoodViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: FoodViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewFoods.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            viewModel.foods.collectLatest { foods ->
                binding.recyclerViewFoods.adapter = FoodAdapter(foods)
            }
        }
    }
}