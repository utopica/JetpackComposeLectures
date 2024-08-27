package com.example.jetpackcomposelectures.week1_2_oop

fun main(){
    ucretHesapla(KonserveBoyut.ORTA, 50)
}

fun ucretHesapla(boyut : KonserveBoyut, adet : Int){

    when(boyut){
        KonserveBoyut.ORTA -> println("Toplam maaliyet : ${adet * 210} ₺")
        KonserveBoyut.KUCUK -> TODO()
        KonserveBoyut.BOYUT -> TODO()
    }

}