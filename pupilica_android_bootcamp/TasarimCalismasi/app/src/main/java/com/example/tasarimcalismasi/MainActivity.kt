package com.example.tasarimcalismasi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        //R (Kotlin sınıfları içerisinde) = res klasörü, kaynaklar
        //@ (Xml dosyalar içerisinde) = res klasörü, kaynaklar
        //<item name="android:statusBarColor">@color/anaRenk</item>


    }
}