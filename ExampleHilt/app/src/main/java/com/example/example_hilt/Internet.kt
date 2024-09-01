package com.example.example_hilt

import android.util.Log

class Internet {

    var adres = Adres("Kadikoy / Istanbul")

    fun basvuru(){
        Log.e("Sonuc", "${adres.bilgi} adresine internet basvurusu yapildi.")
    }
}