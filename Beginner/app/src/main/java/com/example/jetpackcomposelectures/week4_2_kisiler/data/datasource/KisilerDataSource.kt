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

        val guncellenenKisi = Kisiler(kisi_id, kisi_ad, kisi_tel)

        kdao.guncelle(guncellenenKisi)
    }

    suspend fun sil(kisi_id: Int){

        val silinenKisi = Kisiler(kisi_id, "","")

        kdao.sil(silinenKisi)

    }

    suspend fun ara(aramaKelimesi : String) : List<Kisiler> = withContext(Dispatchers.IO){

        return@withContext kdao.ara(aramaKelimesi)
    }

    suspend fun kisileriYukle() : List<Kisiler> = withContext(Dispatchers.IO){
        return@withContext kdao.kisileriYukle()
    }
}