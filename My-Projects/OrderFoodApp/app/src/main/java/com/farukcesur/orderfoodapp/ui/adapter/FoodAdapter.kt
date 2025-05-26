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

    inner class FoodViewHolder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.binding.apply {
            tvFoodName.text = food.yemek_adi
            tvFoodPrice.text = "₺${food.yemek_fiyat}"
            val imageUrl = "http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
            Glide.with(ivFoodImage.context)
                .load(imageUrl)
                .into(ivFoodImage)
        }
    }

    override fun getItemCount(): Int = foodList.size

    fun submitList(list: List<Food>) {
        this.foodList = list
        notifyDataSetChanged()
    }
}