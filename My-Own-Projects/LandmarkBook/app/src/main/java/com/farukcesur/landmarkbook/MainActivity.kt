package com.farukcesur.landmarkbook

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.farukcesur.landmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList: ArrayList<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        landmarkList = ArrayList<Landmark>()

        val istanbul = Landmark("İstanbul", "Türkiye", R.drawable.istanbul)
        val konya = Landmark("Konya", "Türkiye", R.drawable.konya)
        val kabe = Landmark("Kabe", "Arabistan", R.drawable.kabe)
        val medine = Landmark("Medine", "Arabistan", R.drawable.medine)

        landmarkList.add(istanbul)
        landmarkList.add(konya)
        landmarkList.add(kabe)
        landmarkList.add(medine)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkList.map { landmark -> landmark.name })
        binding.listView.adapter = adapter

        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val intent = Intent(MainActivity@ this, DetailsActivity::class.java)
                intent.putExtra("landmark", landmarkList.get(position))
                startActivity(intent)
            }
    }
}