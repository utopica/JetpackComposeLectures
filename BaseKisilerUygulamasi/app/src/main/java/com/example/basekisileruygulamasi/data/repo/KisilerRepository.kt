package com.example.basekisileruygulamasi.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.basekisileruygulamasi.data.datasource.KisilerDataSource
import com.example.basekisileruygulamasi.data.entity.Kisiler

class KisilerRepository(var kds:KisilerDataSource) {

    suspend fun kaydet(kisi_ad:String,kisi_tel:String) = kds.kaydet(kisi_ad, kisi_tel)

    suspend fun guncelle(kisi_id:String,kisi_ad:String,kisi_tel:String) = kds.guncelle(kisi_id, kisi_ad, kisi_tel)

    suspend fun sil(kisi_id:String) = kds.sil(kisi_id)

    suspend fun kisileriYukle() : MutableLiveData<List<Kisiler>> = kds.kisileriYukle()

    suspend fun ara(aramaKelimesi:String) : MutableLiveData<List<Kisiler>> =  kds.ara(aramaKelimesi)
}