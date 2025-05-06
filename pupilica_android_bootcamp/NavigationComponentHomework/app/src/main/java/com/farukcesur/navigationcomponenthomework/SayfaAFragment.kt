package com.farukcesur.navigationcomponenthomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.farukcesur.navigationcomponenthomework.databinding.FragmentSayfaABinding

class SayfaAFragment : Fragment() {
    private lateinit var binding: FragmentSayfaABinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSayfaABinding.inflate(inflater,container,false)


        binding.gitBButton.setOnClickListener {
            val gecis = SayfaAFragmentDirections.actionSayfaAFragmentToSayfaBFragment()
            findNavController().navigate(gecis)
        }

        return binding.root
    }
}