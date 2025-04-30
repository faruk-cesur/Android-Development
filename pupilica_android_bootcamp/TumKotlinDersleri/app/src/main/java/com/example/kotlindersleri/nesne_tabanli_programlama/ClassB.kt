package com.example.kotlindersleri.nesne_tabanli_programlama

class ClassB : MyInterface {
    override var degisken: Int = 100

    override fun metod1() {
        println("Metod 1 çalıştı")
    }

    override fun metod2(): String {
        return "Metod 2 çalıştı"
    }
}