package com.example.example_hilt

import android.util.Log
import javax.inject.Inject

class Kargo @Inject constructor(var adres: Adres) {

    fun gonder(){
        Log.e("Sonuc", "${adres.bilgi} adresine kargo gonderildi.")
    }
}