package com.example.jetpackcomposelectures.week4_2_kisiler.uix.viewmodel

import androidx.lifecycle.ViewModel
import com.example.jetpackcomposelectures.week4_2_kisiler.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiKayitViewModel : ViewModel(){

    var krepo = KisilerRepository()

    fun kaydet(kisi_ad: String, kisi_tel:String){
        CoroutineScope(Dispatchers.Main).launch { //asenkron işlemi sonlandır.
            krepo.kaydet(kisi_ad, kisi_tel)
        }
    }

}
