package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.retrofit.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kisilerDao: KisilerDao) {
    suspend fun kaydet(kisi_ad: String,kisi_tel: String){
        val crudCevap = kisilerDao.kaydet(kisi_ad,kisi_tel)
        Log.e("Kişi Kaydet","Success : ${crudCevap.success} - Message : ${crudCevap.message}")
    }

    suspend fun guncelle(kisi_id:Int,kisi_ad: String,kisi_tel: String){
        val crudCevap = kisilerDao.guncelle(kisi_id,kisi_ad,kisi_tel)
        Log.e("Kişi Güncelle","Success : ${crudCevap.success} - Message : ${crudCevap.message}")
    }

    suspend fun sil(kisi_id:Int){
        val crudCevap = kisilerDao.sil(kisi_id)
        Log.e("Kişi Sil","Success : ${crudCevap.success} - Message : ${crudCevap.message}")
    }

    suspend fun kisileriYukle() : List<Kisiler> = withContext(Dispatchers.IO) {
        return@withContext kisilerDao.kisileriYukle().kisiler
    }

    suspend fun ara(aramaKelimesi:String) : List<Kisiler> = withContext(Dispatchers.IO) {
        return@withContext kisilerDao.ara(aramaKelimesi).kisiler
    }
}