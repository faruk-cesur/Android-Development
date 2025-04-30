package com.example.kotlindersleri.collections

fun main() {
    val f1 = Filmler(1,"Babam Oğlum",50)
    val f2 = Filmler(2,"Neşeli Hayatlar",30)
    val f3 = Filmler(3,"Kış Uykusu",80)

    val filmlerListesi = ArrayList<Filmler>()
    filmlerListesi.add(f1)
    filmlerListesi.add(f2)
    filmlerListesi.add(f3)

    for(film in filmlerListesi){
        println("${film.id} : ${film.ad} ${film.fiyat}TL")
    }

    //Sıralama - Sorting
    println("---- Artan Sıralama -----")
    //Ascend - ASC
    val siralama1 = filmlerListesi.sortedWith(compareBy{ it.ad })
    for(film in siralama1){
        println("${film.id} : ${film.ad} ${film.fiyat}TL")
    }

    println("---- Azalan Sıralama -----")
    //DESC
    val siralama2 = filmlerListesi.sortedWith(compareByDescending{ it.ad })
    for(film in siralama2){
        println("${film.id} : ${film.ad} ${film.fiyat}TL")
    }

    //Filtreleme
    println("------ Filtreleme 1 -----")
    val filtreleme1 = filmlerListesi.filter { it.fiyat > 40 && it.fiyat < 60}
    for(film in filtreleme1){
        println("${film.id} : ${film.ad} ${film.fiyat}TL")
    }

    println("------ Filtreleme 2 -----")
    val filtreleme2 = filmlerListesi.filter { it.ad.contains("at") }
    for(film in filtreleme2){
        println("${film.id} : ${film.ad} ${film.fiyat}TL")
    }

}