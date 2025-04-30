package com.example.kotlindersleri.nesne_tabanli_programlama

fun main() {
    val sonuc = 5 carp 2//5.carp(2)
    println(sonuc)
}

infix fun Int.carp(sayi:Int) : Int {
    return this * sayi//this(Int)
}
