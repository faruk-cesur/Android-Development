package com.example.kotlindersleri.collections

fun main() {
    //HASHSET
    //Tanımlama
    val meyveler = HashSet<String>()
    //Any -> en üst sınıf demek
    //Bütün türleri kapsar.
    //Java -> Object

    meyveler.add("Elma")
    meyveler.add("Muz")
    meyveler.add("Kiraz")
    println(meyveler)

    meyveler.add("Amasya Elma")
    println(meyveler)

    val y = meyveler.elementAt(2)
    println(y)

    println("Boyut : ${meyveler.size}")

    for(meyve in meyveler){
        println("Sonuç : $meyve")
    }

    for((indeks,meyve) in meyveler.withIndex()){//Swift : enumarated()
        println("$indeks. -> $meyve")
    }

    meyveler.remove("Elma")
    println(meyveler)

    meyveler.clear()
    println(meyveler)
}