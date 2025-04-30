package com.example.kotlindersleri.collections

fun main() {
    //Tanımlama
    val meyveler = ArrayList<String>()

    //Veri ekleme : en sonuna ekleme yapar
    meyveler.add("Elma")//0.
    meyveler.add("Muz")//1.
    meyveler.add("Kiraz")//2.
    println(meyveler)

    //Güncelleme
    meyveler[1] = "Yeni Muz"
    println(meyveler)

    //Insert : istediğimiz bir indekse
    meyveler.add(1,"Portakal")
    println(meyveler)

    //Okuma
    val m = meyveler.get(3)
    println(m)
    println(meyveler[3])

    println("Boyut : ${meyveler.size}")

    meyveler.reverse()
    println(meyveler)

    for(meyve in meyveler){
        println("Sonuç : $meyve")
    }

    for((indeks,meyve) in meyveler.withIndex()){//Swift : enumarated()
        println("$indeks. -> $meyve")
    }

    meyveler.removeAt(1)
    println(meyveler)

    meyveler.clear()
    println(meyveler)
}