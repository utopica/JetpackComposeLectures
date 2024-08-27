package com.example.jetpackcomposelecturesmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel : ViewModel() {

    var sonuc = MutableLiveData("0")

    var mathrepo = MathRepository()

    fun topla(alinanSayi1: String, alinanSayi2: String){

        CoroutineScope(Dispatchers.Main).launch{

            sonuc.value = mathrepo.topla(alinanSayi1, alinanSayi2)

        } //arayüze yakınsa main, veri ye yakınsak IO
    }

    fun carp(alinanSayi1: String, alinanSayi2: String){

        CoroutineScope(Dispatchers.Main).launch {

            sonuc.value = mathrepo.carp(alinanSayi1, alinanSayi2)

        }
    }
}