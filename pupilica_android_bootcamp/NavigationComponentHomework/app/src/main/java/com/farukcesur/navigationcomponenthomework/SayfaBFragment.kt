package com.farukcesur.navigationcomponenthomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.farukcesur.navigationcomponenthomework.databinding.FragmentSayfaBBinding

class SayfaBFragment : Fragment() {
    private lateinit var binding : FragmentSayfaBBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSayfaBBinding.inflate(inflater,container,false)


        binding.gitYButton.setOnClickListener {
            val gecis = SayfaBFragmentDirections.actionSayfaBFragmentToSayfaYFragment()
            findNavController().navigate(gecis)
        }

        return binding.root
    }
}