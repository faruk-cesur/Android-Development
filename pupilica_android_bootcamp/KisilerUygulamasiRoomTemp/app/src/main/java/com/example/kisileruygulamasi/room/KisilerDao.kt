package com.example.kisileruygulamasi.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kisileruygulamasi.data.entity.Kisiler

@Dao
interface KisilerDao { //Dao : Database Access Object
    @Query("SELECT * FROM kisiler")
    suspend fun kisileriYukle() : List<Kisiler>

    @Insert
    suspend fun kaydet(kisi: Kisiler)

    @Update
    suspend fun guncelle(kisi: Kisiler)
}