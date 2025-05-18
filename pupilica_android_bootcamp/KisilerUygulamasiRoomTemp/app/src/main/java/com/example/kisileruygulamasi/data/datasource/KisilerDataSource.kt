package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.room.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kisilerDao: KisilerDao) {
    suspend fun kaydet(kisi_ad: String,kisi_tel: String){
        val yeniKisi = Kisiler(0,kisi_ad,kisi_tel)
        kisilerDao.kaydet(yeniKisi)
    }

    suspend fun guncelle(kisi_id:Int,kisi_ad: String,kisi_tel: String){
        val guncellenenKisi = Kisiler(kisi_id,kisi_ad,kisi_tel)
        kisilerDao.guncelle(guncellenenKisi)
    }

    suspend fun sil(kisi_id:Int){
        Log.e("Kişi Sil",kisi_id.toString())
    }

    suspend fun kisileriYukle() : List<Kisiler> = withContext(Dispatchers.IO) {
        return@withContext  kisilerDao.kisileriYukle()
    }

    suspend fun ara(aramaKelimesi:String) : List<Kisiler> = withContext(Dispatchers.IO) {
        val liste = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Ahmet","1111")
        liste.add(k1)

        return@withContext  liste
    }
}