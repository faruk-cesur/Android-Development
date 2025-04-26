package com.example.kotlindersleri.nesne_tabanli_programlama

data class Yemekler(var id:Int,var ad:String,var fiyat:Int) {
    //Constructor - init fonksiyonu
    //Bu sınıftan nesne oluştuğunda çalışsın.
    init {
        println("****** Nesne Oluştu *****")
    }

    fun bilgiAl(){
        println("-----------------")
        println("Id    : ${id}")
        println("Ad    : ${ad}")
        println("Fiyat : ${fiyat}")
    }
    //this : Bulunduğu sınıfı temsil eder.Swift dilinde self
    //super : Kalıtım ile bir üst sınıfı temsil eder.
}