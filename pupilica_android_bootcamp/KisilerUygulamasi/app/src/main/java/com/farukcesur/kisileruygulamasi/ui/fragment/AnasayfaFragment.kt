package com.farukcesur.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.farukcesur.kisileruygulamasi.R
import com.farukcesur.kisileruygulamasi.data.entity.Kisiler
import com.farukcesur.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.farukcesur.kisileruygulamasi.ui.adapter.KisilerAdapter

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

        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Ahmet","1111")
        val k2 = Kisiler(2,"Zeynep","2222")
        val k3 = Kisiler(3,"Beyza","3333")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)

        val kisilerAdapter = KisilerAdapter(requireContext(),kisilerListesi)
        binding.kisilerRv.adapter = kisilerAdapter
        binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext())

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

    override fun onResume() {
        super.onResume()
        Log.e("Kişi Anasayfaya", "Dönüldü")

    }
}