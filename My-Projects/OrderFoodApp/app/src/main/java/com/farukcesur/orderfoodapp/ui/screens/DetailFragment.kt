package com.farukcesur.orderfoodapp.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.farukcesur.orderfoodapp.R
import com.farukcesur.orderfoodapp.data.model.Food
import com.farukcesur.orderfoodapp.databinding.FragmentDetailBinding
import com.farukcesur.orderfoodapp.ui.viewmodel.FoodViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FoodViewModel by activityViewModels()

    private val args: DetailFragmentArgs by navArgs()
    private lateinit var currentFood: Food

    private var localQuantity = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentFood = args.food

        binding.textViewName.text = currentFood.yemek_adi
        binding.textViewPrice.text = "₺${currentFood.yemek_fiyat}"

        Glide.with(requireContext())
            .load("http://kasimadalan.pe.hu/yemekler/resimler/${currentFood.yemek_resim_adi}")
            .into(binding.imageViewFood)

        updateFavoriteIcon()

        binding.btnFavoriteFromDetail.setOnClickListener {
            if (viewModel.isFavorite(currentFood)) {
                viewModel.removeFromFavorites(currentFood)
                Toast.makeText(requireContext(), "Favorilerden çıkarıldı", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.addToFavorites(currentFood)
                Toast.makeText(requireContext(), "Favorilere eklendi", Toast.LENGTH_SHORT).show()
            }
            updateFavoriteIcon()
        }

        var selectedQuantity = 1
        binding.textQuantity.text = selectedQuantity.toString()
        updateTotalPrice(selectedQuantity)

        binding.buttonIncrease.setOnClickListener {
            selectedQuantity++
            binding.textQuantity.text = selectedQuantity.toString()
            updateTotalPrice(selectedQuantity)
        }

        binding.buttonDecrease.setOnClickListener {
            if (selectedQuantity > 1) {
                selectedQuantity--
                binding.textQuantity.text = selectedQuantity.toString()
                updateTotalPrice(selectedQuantity)
            }
        }

        binding.btnAddToCartFromDetail.setOnClickListener {
            viewModel.addToCart(currentFood, selectedQuantity)
            Toast.makeText(requireContext(), "$selectedQuantity adet sepete eklendi", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateTotalPrice(quantity: Int) {
        val unitPrice = currentFood.yemek_fiyat.toIntOrNull() ?: 0
        val totalPrice = unitPrice * quantity
        binding.textViewPrice.text = "₺$totalPrice"
    }

    private fun updateFavoriteIcon() {
        val isFav = viewModel.isFavorite(currentFood)
        val iconRes = if (isFav) R.drawable.ic_favorite else R.drawable.ic_favorite_border
        binding.btnFavoriteFromDetail.setImageResource(iconRes)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}