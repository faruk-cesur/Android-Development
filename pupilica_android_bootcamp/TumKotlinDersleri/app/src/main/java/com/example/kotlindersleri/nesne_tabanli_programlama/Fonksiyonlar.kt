package com.example.kotlindersleri.nesne_tabanli_programlama

class Fonksiyonlar {
    //void - sadece işlem yapan
    fun selamla1() {//Swift -> func
        val sonuc = "Merhaba Ahmet"
        println(sonuc)
    }

    //return - hem işlem yapan hem veri transferi yapan
    fun selamla2() : String {
        val sonuc = "Merhaba Ahmet"
        return sonuc
    }

    //parametre
    fun selamla3(isim:String) {
        val sonuc = "Merhaba $isim"
        println(sonuc)
    }

    //Overloading
    //Bir sınıf içerisinde aynı isimde fonksiyonları tekrar kullanmak.
    fun topla(sayi1:Int,sayi2:Int){
        println("Toplama : ${sayi1+sayi2}")
    }

    fun topla(sayi1:Double,sayi2:Double){
        println("Toplama : ${sayi1+sayi2}")
    }

    fun topla(sayi1:Int,sayi2:Int,isim:String){
        println("Toplama : ${sayi1+sayi2} - İşlem Yapan : $isim")
    }
}