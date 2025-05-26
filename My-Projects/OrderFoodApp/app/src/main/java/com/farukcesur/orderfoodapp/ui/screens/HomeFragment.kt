package com.farukcesur.orderfoodapp.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.farukcesur.orderfoodapp.R
import com.farukcesur.orderfoodapp.databinding.FragmentHomeBinding
import com.farukcesur.orderfoodapp.ui.adapter.FoodAdapter
import com.farukcesur.orderfoodapp.ui.viewmodel.FoodViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FoodViewModel by viewModels()
    private lateinit var adapter: FoodAdapter

    private var searchJob: Job? = null // debounce için gerekli

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ✅ Adapter kur ve sepete ekleme olayını dinle
        adapter = FoodAdapter(onAddToCartClick = { selectedFood ->
            viewModel.addToCart(selectedFood)
            Toast.makeText(
                requireContext(),
                "${selectedFood.yemek_adi} sepete eklendi",
                Toast.LENGTH_SHORT
            ).show()
        })

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = this@HomeFragment.adapter
        }

        // Veri akışlarını gözlemle
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.foods.collectLatest { list ->
                adapter.submitList(list)
                binding.textViewNoResults.visibility =
                    if (list.isEmpty()) View.VISIBLE else View.GONE
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.error.collectLatest { err ->
                err?.let {
                    Toast.makeText(requireContext(), "Hata: $it", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Arama işlevi
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?) = true.also {
                query?.let { viewModel.searchFoods(it) }
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchJob?.cancel()
                searchJob = viewLifecycleOwner.lifecycleScope.launch {
                    delay(300)
                    viewModel.searchFoods(newText.orEmpty())
                }
                return true
            }
        })

        // Başlangıçta veri çek
        viewModel.fetchFoods()

        // ✅ Alt Menü Butonları ile Navigasyon
        binding.btnHome.setOnClickListener {
            // Zaten home'tasın, istersen refresh yap
            viewModel.fetchFoods()
        }

//        binding.btnFavorites.setOnClickListener {
//            findNavController().navigate(R.id.action_homeFragment_to_favoritesFragment)
//        }

        binding.btnCart.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_cartFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
