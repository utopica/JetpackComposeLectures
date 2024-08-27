package com.example.jetpackcomposelecturesmvvm

import androidx.lifecycle.ViewModel

class AnasayfaViewModel : ViewModel() {

    var sonuc = "0"

    fun topla(alinanSayi1: String, alinanSayi2: String){

        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()

        val toplam = sayi1 + sayi2

        sonuc = toplam.toString()
    }

    fun carp(alinanSayi1: String, alinanSayi2: String){

        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()

        val carpma = sayi1 * sayi2

        sonuc = carpma.toString()
    }
}