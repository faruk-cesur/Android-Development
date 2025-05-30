package com.farukcesur.orderfoodapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farukcesur.orderfoodapp.R
import com.farukcesur.orderfoodapp.data.model.CartItem

class CartAdapter(
    private val cartItems: List<CartItem>,
    private val onDeleteClick: (CartItem) -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodImage: ImageView = itemView.findViewById(R.id.imageViewCartFood)
        val foodName: TextView = itemView.findViewById(R.id.textViewCartFoodName)
        val foodPrice: TextView = itemView.findViewById(R.id.textViewCartFoodPrice)
        val deleteIcon: ImageView = itemView.findViewById(R.id.imageViewDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = cartItems[position]

        holder.foodName.text = cartItem.yemek.yemek_adi

        val unitPrice = cartItem.yemek.yemek_fiyat.toIntOrNull() ?: 0
        val quantity = cartItem.quantity
        val totalPrice = unitPrice * quantity

        holder.foodPrice.text = "₺$unitPrice x $quantity = ₺$totalPrice"

        Glide.with(holder.itemView.context)
            .load("http://kasimadalan.pe.hu/yemekler/resimler/${cartItem.yemek.yemek_resim_adi}")
            .into(holder.foodImage)

        holder.deleteIcon.setOnClickListener {
            onDeleteClick(cartItem)
        }
    }

    override fun getItemCount() = cartItems.size
}