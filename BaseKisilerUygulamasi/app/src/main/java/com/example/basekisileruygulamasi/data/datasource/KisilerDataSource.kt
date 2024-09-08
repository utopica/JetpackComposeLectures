package com.example.basekisileruygulamasi.data.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.basekisileruygulamasi.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {

    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    suspend fun kaydet(kisi_ad:String,kisi_tel:String){
        Log.e("Kişi Kaydet","$kisi_ad - $kisi_tel")
    }

    suspend fun guncelle(kisi_id:String,kisi_ad:String,kisi_tel:String){
        Log.e("Kişi Güncelle","$kisi_id - $kisi_ad - $kisi_tel")
    }

    suspend fun sil(kisi_id:String){
        Log.e("Kişi Sil",kisi_id.toString())
    }

    suspend fun kisileriYukle() : MutableLiveData<List<Kisiler>>{
        return kisilerListesi
    }

    suspend fun ara(aramaKelimesi:String) : MutableLiveData<List<Kisiler>>{
      return kisilerListesi
    }

}