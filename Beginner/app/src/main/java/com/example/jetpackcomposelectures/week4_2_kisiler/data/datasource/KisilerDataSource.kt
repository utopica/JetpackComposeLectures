package com.example.jetpackcomposelectures.week4_2_kisiler.data.datasource

import android.util.Log
import com.example.jetpackcomposelectures.week4_2_kisiler.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {

    suspend fun kaydet(kisi_ad: String, kisi_tel:String){
        Log.e("Kisi Kaydet", "$kisi_ad - $kisi_tel")
    }

    suspend fun guncelle(kisi_id:Int, kisi_ad:String, kisi_tel:String){
        Log.e("Kisi Guncelle", "$kisi_id - $kisi_ad- $kisi_tel")
    }

    suspend fun sil(kisi_id: Int){
        Log.e("Kisi Sil", kisi_id.toString())
    }

    suspend fun ara(aramaKelimesi : String) : List<Kisiler> = withContext(Dispatchers.IO){
        val kisilerListesi = ArrayList<Kisiler>()

        val kisi1 = Kisiler(1, "Ahmet", "1111")
        val kisi2 = Kisiler(2, "Zeynep", "2222")
        val kisi3 = Kisiler(3, "Beyza", "3333")

        kisilerListesi.add(kisi1)
        kisilerListesi.add(kisi2)
        kisilerListesi.add(kisi3)

        return@withContext kisilerListesi
    }

    suspend fun kisileriYukle() : List<Kisiler> = withContext(Dispatchers.IO){
        val kisilerListesi = ArrayList<Kisiler>()

        val kisi1 = Kisiler(1, "Ahmet", "1111")
        val kisi2 = Kisiler(2, "Zeynep", "2222")
        val kisi3 = Kisiler(3, "Beyza", "3333")

        kisilerListesi.add(kisi1)
        kisilerListesi.add(kisi2)
        kisilerListesi.add(kisi3)

        return@withContext kisilerListesi
    }
}