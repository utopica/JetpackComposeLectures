package com.example.basekisileruygulamasi.data.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.basekisileruygulamasi.data.entity.Kisiler
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource (var collectionKisiler: CollectionReference){

    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    fun kaydet(kisi_ad:String,kisi_tel:String){

        val yeniKisi = Kisiler("", kisi_ad, kisi_tel)
        collectionKisiler.document().set(yeniKisi)
    }

    fun guncelle(kisi_id:String,kisi_ad:String,kisi_tel:String){

        val guncellenenKisi = HashMap<String, Any>()
        guncellenenKisi["kisi_ad"] = kisi_ad
        guncellenenKisi["kisi_tel"] = kisi_tel
        collectionKisiler.document(kisi_id).update(guncellenenKisi)
    }

    fun sil(kisi_id:String){
        collectionKisiler.document(kisi_id).delete()
    }

    fun kisileriYukle() : MutableLiveData<List<Kisiler>>{

        collectionKisiler.addSnapshotListener{value, error ->
            if(value != null){
                val liste = ArrayList<Kisiler>()

                for(document in value.documents){
                    val kisi = document.toObject(Kisiler::class.java)
                    if(kisi != null){
                        kisi.kisi_id = document.id
                        liste.add(kisi)
                    }
                }

                kisilerListesi.value = liste
            }
        }
        return kisilerListesi
    }

    fun ara(aramaKelimesi:String) : MutableLiveData<List<Kisiler>>{
      collectionKisiler.addSnapshotListener{value, error->
          if(value != null){
              val liste = ArrayList<Kisiler>()

              for(document in value.documents){
                  val kisi = document.toObject(Kisiler::class.java)
                  if(kisi != null){
                      kisi.kisi_id = document.id

                      if(kisi.kisi_ad!!.lowercase().contains(aramaKelimesi.lowercase())){
                          liste.add(kisi)

                      }
                  }
              }

              kisilerListesi.value = liste
          }
      }

        return kisilerListesi
    }

}