package com.farukcesur.orderfoodapp.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
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
    private val viewModel: FoodViewModel by activityViewModels()
    private lateinit var adapter: FoodAdapter

    private var searchJob: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FoodAdapter(
            foodViewModel = viewModel,
            onAddToCartClick = { selectedFood ->
                viewModel.addToCart(selectedFood, 1)
                Toast.makeText(
                    requireContext(),
                    "${selectedFood.yemek_adi} sepete eklendi",
                    Toast.LENGTH_SHORT
                ).show()
            },
            onItemClick = { selectedFood ->
                val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(selectedFood)
                findNavController().navigate(action)
            }
        )

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = this@HomeFragment.adapter
        }

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

        viewModel.fetchFoods()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
