package com.example.jetpackcomposelectures.week4_2_kisiler.data.datasource

import android.util.Log
import com.example.jetpackcomposelectures.week4_2_kisiler.data.entity.Kisiler
import com.example.jetpackcomposelectures.week4_2_kisiler.data.repo.KisilerRepository
import com.example.jetpackcomposelectures.week4_2_kisiler.room.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kdao : KisilerDao) {

    suspend fun kaydet(kisi_ad: String, kisi_tel:String){

        val yeniKisi = Kisiler(0, kisi_ad, kisi_tel)

        kdao.kaydet(yeniKisi)
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

        kisilerListesi.add(kisi1)

        return@withContext kisilerListesi
    }

    suspend fun kisileriYukle() : List<Kisiler> = withContext(Dispatchers.IO){
        return@withContext kdao.kisileriYukle()
    }
}