package com.farukcesur.orderfoodapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farukcesur.orderfoodapp.data.model.Food
import com.farukcesur.orderfoodapp.databinding.ItemFoodBinding

class FoodAdapter(
    private var foodList: List<Food> = emptyList()
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(private val binding: ItemFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            binding.tvFoodName.text = food.yemek_adi
            binding.tvFoodPrice.text = "₺${food.yemek_fiyat}"
            val imageUrl = "http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
            Glide.with(binding.ivFoodImage.context)
                .load(imageUrl)
                .into(binding.ivFoodImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foodList[position])
    }

    override fun getItemCount(): Int = foodList.size

    fun submitList(list: List<Food>) {
        foodList = list
        notifyDataSetChanged()
    }
}