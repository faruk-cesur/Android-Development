package com.farukcesur.orderfoodapp.ui.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.farukcesur.orderfoodapp.databinding.FragmentHomeBinding
import com.farukcesur.orderfoodapp.ui.adapter.FoodAdapter
import com.farukcesur.orderfoodapp.ui.viewmodel.FoodViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FoodViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
    }

    private fun setupObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.foods.collectLatest { foodList ->
                if (foodList.isNotEmpty()) {
                    val adapter = FoodAdapter(foodList)
                    binding.recyclerView.apply {
                        layoutManager = GridLayoutManager(requireContext(), 2)
                        this.adapter = adapter
                    }
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.error.collectLatest { errorMessage ->
                errorMessage?.let {
                    // Hata mesajı gösterilebilir, örneğin Toast ile
                    // Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}