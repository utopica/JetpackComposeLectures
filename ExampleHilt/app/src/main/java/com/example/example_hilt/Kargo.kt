package com.example.example_hilt

import android.util.Log

class Kargo {
    var adres = Adres("Kadikoy / Istanbul")

    fun gonder(){
        Log.e("Sonuc", "${adres.bilgi} adresine kargo gonderildi.")
    }
}