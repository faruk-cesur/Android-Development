package com.farukcesur.kisileruygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.farukcesur.kisileruygulamasi.R
import com.farukcesur.kisileruygulamasi.data.entity.Kisiler
import com.farukcesur.kisileruygulamasi.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        }

        binding.buttonDetay.setOnClickListener {
            val x = Kisiler(1, "Ahmet", "1111")
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi = x)
            Navigation.findNavController(it).navigate(gecis)
        }

        return binding.root
    }
}