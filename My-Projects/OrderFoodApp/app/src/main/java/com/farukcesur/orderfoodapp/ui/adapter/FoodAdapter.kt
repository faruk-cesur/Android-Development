package com.farukcesur.orderfoodapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.farukcesur.orderfoodapp.data.model.Food
import com.farukcesur.orderfoodapp.databinding.ItemFoodBinding

class FoodAdapter(
    private val foodList: List<Food>
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.binding.apply {
            tvFoodName.text = food.name
            tvFoodDescription.text = food.description
            tvFoodPrice.text = "${food.price} ₺"
            // Glide ile resim yükleme (eğer Glide varsa)
            // Glide.with(ivFoodImage.context).load(food.imageUrl).into(ivFoodImage)
        }
    }

    override fun getItemCount(): Int = foodList.size
}