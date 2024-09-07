package com.example.kisileruygulamasihilt.data.datasource

import android.util.Log
import com.example.kisileruygulamasihilt.data.entity.Kisiler
import com.example.kisileruygulamasihilt.retrofit.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource (var kdao: KisilerDao){
    suspend fun kaydet(kisi_ad:String,kisi_tel:String){
        kdao.kaydet(kisi_ad, kisi_tel)
    }

    suspend fun guncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        Log.e("Kişi Güncelle","$kisi_id - $kisi_ad - $kisi_tel")

    }

    suspend fun sil(kisi_id:Int){
        Log.e("Kişi Sil",kisi_id.toString())
    }

    suspend fun kisileriYukle() : List<Kisiler> = withContext(Dispatchers.IO){
        return@withContext kdao.kisileriYukle().kisiler
    }

    suspend fun ara(aramaKelimesi:String) : List<Kisiler> = withContext(Dispatchers.IO){
        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Ahmet","1111")
        kisilerListesi.add(k1)

        return@withContext kisilerListesi
    }

}