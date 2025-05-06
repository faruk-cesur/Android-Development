package com.farukcesur.navigationcomponenthomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.farukcesur.navigationcomponenthomework.databinding.FragmentSayfaXBinding

class SayfaXFragment : Fragment() {
    private lateinit var binding: FragmentSayfaXBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSayfaXBinding.inflate(inflater,container,false)


        binding.gitYButton2.setOnClickListener {
            val gecis = SayfaXFragmentDirections.actionSayfaXFragmentToSayfaYFragment()
            findNavController().navigate(gecis)
        }

        return binding.root
    }
}