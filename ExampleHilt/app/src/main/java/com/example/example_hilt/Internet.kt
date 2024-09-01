package com.example.example_hilt

import android.util.Log
import javax.inject.Inject

class Internet @Inject constructor(var adres: Adres){

    fun basvuru(){
        Log.e("Sonuc", "${adres.bilgi} adresine internet basvurusu yapildi.")
    }
}