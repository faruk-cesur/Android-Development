package com.farukcesur.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
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

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean { // Harf girdikçe ve sildikçe
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean { // Ara butonuna basılınca
                ara(query)
                return true
            }
        })

        return binding.root
    }

    fun ara(aramaKelimesi:String){
        Log.e("Kişi Ara", aramaKelimesi)
    }
}