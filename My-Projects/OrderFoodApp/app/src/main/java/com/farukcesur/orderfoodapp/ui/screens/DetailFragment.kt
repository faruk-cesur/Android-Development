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
import com.farukcesur.orderfoodapp.databinding.FragmentDetailBinding
import com.farukcesur.orderfoodapp.ui.viewmodel.FoodViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FoodViewModel by activityViewModels()

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val food = args.food

        binding.textViewName.text = food.yemek_adi
        binding.textViewPrice.text = "₺${food.yemek_fiyat}"

        Glide.with(requireContext())
            .load("http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}")
            .into(binding.imageViewFood)

        binding.btnAddToCartFromDetail.setOnClickListener {
            viewModel.addToCart(food)
            Toast.makeText(requireContext(), "Sepete eklendi", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
