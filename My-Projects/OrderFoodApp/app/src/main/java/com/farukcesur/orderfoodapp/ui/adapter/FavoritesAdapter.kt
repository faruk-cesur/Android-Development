package com.farukcesur.orderfoodapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farukcesur.orderfoodapp.databinding.ItemFoodBinding
import com.farukcesur.orderfoodapp.data.model.Food
import com.farukcesur.orderfoodapp.ui.viewmodel.FoodViewModel
import com.farukcesur.orderfoodapp.R

class FavoritesAdapter(
    private val viewModel: FoodViewModel
) : RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {

    private var favoriteList: List<Food> = listOf()

    fun submitList(list: List<Food>) {
        favoriteList = list
        notifyDataSetChanged()
    }

    inner class FavoritesViewHolder(private val binding: ItemFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(food: Food) {
            binding.apply {
                tvFoodName.text = food.yemek_adi
                tvFoodPrice.text = "${food.yemek_fiyat} ₺"

                Glide.with(ivFoodImage.context)
                    .load("http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}")
                    .into(ivFoodImage)

                val isFavorite = viewModel.isFavorite(food)
                btnFavorite.setImageResource(
                    if (isFavorite) R.drawable.ic_favorite
                    else R.drawable.ic_favorite_border
                )

                btnFavorite.setOnClickListener {
                    if (isFavorite) {
                        viewModel.removeFromFavorites(food)
                    } else {
                        viewModel.addToFavorites(food)
                    }
                }

                btnAddToCart.setOnClickListener {
                    viewModel.addToCart(food, 1)
                    Toast.makeText(binding.root.context, "${food.yemek_adi} sepete eklendi", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val binding = ItemFoodBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FavoritesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bind(favoriteList[position])
    }

    override fun getItemCount(): Int = favoriteList.size
}