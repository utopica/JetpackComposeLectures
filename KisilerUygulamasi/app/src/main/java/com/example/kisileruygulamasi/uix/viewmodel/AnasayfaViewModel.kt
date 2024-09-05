package com.example.jetpackcomposelectures.week4_2_kisiler.uix.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackcomposelectures.week4_2_kisiler.data.entity.Kisiler
import com.example.jetpackcomposelectures.week4_2_kisiler.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel //parametre aktarma özelliği oto yap
class AnasayfaViewModel @Inject constructor(var krepo : KisilerRepository) : ViewModel() {

    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init{
        kisileriYukle()
    } // mutlaka olmalı

    fun sil(kisi_id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            krepo.sil(kisi_id)

            kisileriYukle() //sildikten sonra arayüzde de silmek için
        }
    }

    fun ara(aramaKelimesi : String){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = krepo.ara(aramaKelimesi)
        }
    }

    fun kisileriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = krepo.kisileriYukle()
        }
    }
}