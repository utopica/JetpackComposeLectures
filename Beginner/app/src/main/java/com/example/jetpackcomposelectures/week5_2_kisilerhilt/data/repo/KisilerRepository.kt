package com.example.jetpackcomposelectures.week4_2_kisiler.data.repo

import android.util.Log
import com.example.jetpackcomposelectures.week4_2_kisiler.data.datasource.KisilerDataSource
import com.example.jetpackcomposelectures.week4_2_kisiler.data.entity.Kisiler

class KisilerRepository (var kds : KisilerDataSource){

    suspend fun kaydet(kisi_ad: String, kisi_tel:String) = kds.kaydet(kisi_ad, kisi_tel)
    //data source'a kisi ad ve kisi tel gönder. tek yönlü olduğu için live data yok. coroutine return yok

    suspend fun guncelle(kisi_id:Int, kisi_ad:String, kisi_tel:String) = kds.guncelle(kisi_id, kisi_ad, kisi_tel)

    suspend fun sil(kisi_id: Int) = kds.sil(kisi_id)

    suspend fun ara(aramaKelimesi : String) : List<Kisiler> = kds.ara(aramaKelimesi)

    suspend fun kisileriYukle() : List<Kisiler> = kds.kisileriYukle()
}