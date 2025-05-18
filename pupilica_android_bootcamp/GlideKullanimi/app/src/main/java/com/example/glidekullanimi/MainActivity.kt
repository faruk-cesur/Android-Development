package com.example.glidekullanimi

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.glidekullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val yemekler = listOf("izgarasomon.png","izgaratavuk.png","kofte.png","lazanya.png","makarna.png","pizza.png")
        val tatlilar = listOf("baklava.png","kadayif.png","sutlac.png","tiramisu.png")
        val icecekler = listOf("ayran.png","fanta.png","kahve.png","su.png")

        binding.buttonMenuOlustur.setOnClickListener {
            val yemek = yemekler.random()
            val tatli = tatlilar.random()
            val icecek = icecekler.random()

            resimGoster(yemek,binding.imageViewYemekler)
            resimGoster(tatli,binding.imageViewTatlilar)
            resimGoster(icecek,binding.imageViewIcecekler)
        }
    }

    fun resimGoster(resimAdi:String,imageView: ImageView){
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/$resimAdi"
        Glide.with(this).load(url).override(300,300).into(imageView)
    }
}