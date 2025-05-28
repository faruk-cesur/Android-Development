package com.farukcesur.orderfoodapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
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
                    .load(food.yemek_resim_adi)
                    .into(ivFoodImage)

                // Favori durumuna göre ikon değiştir
                val isFavorite = viewModel.isFavorite(food)
                btnFavorite.setImageResource(
                    if (isFavorite) R.drawable.ic_favorite
                    else R.drawable.ic_favorite_border
                )

                // Favoriye ekleme / çıkarma
                btnFavorite.setOnClickListener {
                    if (isFavorite) {
                        viewModel.removeFromFavorites(food)
                    } else {
                        viewModel.addToFavorites(food)
                    }
                }

                // Sepete ekleme
                btnAddToCart.setOnClickListener {
                    viewModel.addToCart(food)
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