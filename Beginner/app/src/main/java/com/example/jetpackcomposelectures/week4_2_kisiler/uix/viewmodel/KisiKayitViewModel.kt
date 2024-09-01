package com.example.jetpackcomposelectures.week4_2_kisiler.uix.viewmodel

import androidx.lifecycle.ViewModel
import com.example.jetpackcomposelectures.week4_2_kisiler.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiKayitViewModel @Inject constructor(var krepo : KisilerRepository) : ViewModel(){

    fun kaydet(kisi_ad: String, kisi_tel:String){
        CoroutineScope(Dispatchers.Main).launch { //asenkron işlemi sonlandır.
            krepo.kaydet(kisi_ad, kisi_tel)
        }
    }

}
