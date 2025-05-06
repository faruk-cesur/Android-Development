package com.farukcesur.navigationcomponenthomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.farukcesur.navigationcomponenthomework.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater,container,false)

        binding.gitAButton.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.actionAnasayfaFragmentToSayfaAFragment()
            findNavController().navigate(gecis)
        }

        binding.gitXButton.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.actionAnasayfaFragmentToSayfaXFragment()
            findNavController().navigate(gecis)
        }

        return binding.root
    }
}