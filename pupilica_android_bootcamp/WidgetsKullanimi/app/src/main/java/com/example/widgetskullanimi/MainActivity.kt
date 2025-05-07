package com.example.widgetskullanimi

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.widgetskullanimi.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var kontrol = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toggleButton.addOnButtonCheckedListener { group, checkedId, isChecked ->
            kontrol = isChecked
            if(kontrol){
                val secilenButton = findViewById<Button>(checkedId)
                val buttonYazi = secilenButton.text.toString()
                Log.e("Sonuç",buttonYazi)
            }
        }

        val ulkeler = ArrayList<String>()
        ulkeler.add("Türkiye")
        ulkeler.add("İtalya")
        ulkeler.add("Japonya")

        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,ulkeler)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        binding.buttonGoster.setOnClickListener {
            if(kontrol){
                val secilenButton = findViewById<Button>(binding.toggleButton.checkedButtonId)
                val buttonYazi = secilenButton.text.toString()
                Log.e("Sonuç ( Göster )",buttonYazi)
            }
            val secilenUlke = binding.autoCompleteTextView.text.toString()
            Log.e("Sonuç",secilenUlke)
        }

        binding.buttonAlert.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Başlık")
                .setMessage("Mesaj")
                .setPositiveButton("Tamam") {d,i ->
                    Toast.makeText(this,"Tamam Tıklandı", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("İptal"){d,i ->
                    Toast.makeText(this,"İptal Tıklandı", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}