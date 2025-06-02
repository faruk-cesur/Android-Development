package com.farukcesur.orderfoodapp.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.farukcesur.orderfoodapp.databinding.FragmentCartBinding
import com.farukcesur.orderfoodapp.ui.adapter.CartAdapter
import com.farukcesur.orderfoodapp.ui.viewmodel.FoodViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FoodViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewCart.layoutManager = LinearLayoutManager(requireContext())

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.cartItems.collectLatest { cartItems ->
                val adapter = CartAdapter(cartItems) { cartItem ->
                    viewModel.removeFromCart(cartItem.yemek)
                }
                binding.recyclerViewCart.adapter = adapter

                if (cartItems.isEmpty()) {
                    binding.textViewEmptyCart.visibility = View.VISIBLE
                    binding.cartSummaryLayout.visibility = View.GONE
                } else {
                    binding.textViewEmptyCart.visibility = View.GONE
                    binding.cartSummaryLayout.visibility = View.VISIBLE
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.totalPrice.collectLatest { total ->
                val formatted = "Toplam: ₺${total},00"
                binding.tvTotalPrice.text = formatted
            }
        }

        binding.btnConfirmCart.setOnClickListener {
            Toast.makeText(requireContext(), "Sepet onaylandı!", Toast.LENGTH_SHORT).show()
            viewModel.clearCart()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}