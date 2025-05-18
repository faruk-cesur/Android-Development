package com.example.kisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiDetayViewModel : ViewModel() {
    var kisilerRepository = KisilerRepository()

    fun guncelle(kisi_id:Int,kisi_ad: String,kisi_tel: String){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepository.guncelle(kisi_id,kisi_ad,kisi_tel)
        }
    }
}