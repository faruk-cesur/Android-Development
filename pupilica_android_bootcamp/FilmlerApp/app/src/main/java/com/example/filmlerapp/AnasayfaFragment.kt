package com.example.filmlerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmlerapp.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        val filmlerListesi = ArrayList<Filmler>()
        val f1 = Filmler(1, "Django", "django", 24)
        val f2 = Filmler(2, "Interstellar", "interstellar", 32)
        val f3 = Filmler(3, "Inception", "inception", 16)
        val f4 = Filmler(4, "The Hateful Eight", "thehatefuleight", 28)
        val f5 = Filmler(5, "The Pianist", "thepianist", 18)
        val f6 = Filmler(6, "Anadoluda", "anadoluda", 10)
        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)
        filmlerListesi.add(f5)
        filmlerListesi.add(f6)

        val filmlerAdapter = FilmlerAdapter(requireContext(), filmlerListesi)
        binding.filmlerRv.adapter = filmlerAdapter

        binding.filmlerRv.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        return binding.root
    }
}