package com.farukcesur.kotlindersleri.odevler

fun main() {
    val sehir = "İstanbul"
    val ulke = "Türkiye"
    val telefon = "0532 449 17 05"
    val postaKodu = 34743
    val email = "farukces110@gmail.com"
    val meslek = "Android Developer | Kotlin"
    val stokMiktari = 100
    val musteriAdi = "Ahmet Yılmaz"
    val bakiye = 1500.75
    val dogumGunu = "17.05.1997"
    val maas = 18000
    val medeniDurum = "Evli"
    val urunYorum = "Ürün harika"
    val odemeTarihi = "2025-04-22"
    val odeme = 499.99
    val siparisAdeti = 3
    val arabaModeli = "Opel Astra 1.2T"
    val kitapAdi = "Kotlin ile Android Geliştirme"
    val yayinlamaTarihi = "2023-09-15"
    val indirimMiktari = 25
    val odaSayisi = 2
    val enlem = 41.0082
    val boylam = 28.9784
    val urunAdi = "Kablosuz Kulaklık"
    val yemekFiyati = 85.50
    val marka = "Samsung"
    val muzikAdi = "Lofi Study Beats"
    val videoSuresi = "12:45"
    val urunPuani = 4.8
    val resimAdi = "profil.jpg"
    val dosyaFormati = "JPEG"
    val renk = "Siyah"
    val renkKodu = "#000000"
    val telefonModeli = "Galaxy S23"
    val ekranBoyutu = 6.8
    val agirlik = 185.0
    val ulusalGun = "29 Ekim"
    val tatilGunu = "Cumartesi"
    val rezervasyonTarihi = "2025-06-20"
    val sokakAdi = "İnönü Caddesi"
    val otobusHatti = "34AS"
    val kalanDakika = 12
    val takipKodu = "TR123456789"
    val kuponSuresi = "2025-05-01"
    val kuponKodu = "KOTLIN25"
    val faturaAdresi = "Ümraniye, İstanbul"

    val bilgiler = arrayListOf<Any>(
        sehir, ulke, telefon, postaKodu, email, meslek,
        stokMiktari, musteriAdi, bakiye, dogumGunu, maas, medeniDurum,
        urunYorum, odemeTarihi, odeme, siparisAdeti, arabaModeli, kitapAdi,
        yayinlamaTarihi, indirimMiktari, odaSayisi, enlem, boylam, urunAdi,
        yemekFiyati, marka, muzikAdi, videoSuresi, urunPuani, resimAdi,
        dosyaFormati, renk, renkKodu, telefonModeli, ekranBoyutu, agirlik,
        ulusalGun, tatilGunu, rezervasyonTarihi, sokakAdi, otobusHatti,
        kalanDakika, takipKodu, kuponSuresi, kuponKodu, faturaAdresi
    )

    for (bilgi in bilgiler) {
        println("Değer: $bilgi | Tür: ${bilgi::class.simpleName}")
    }
}