package com.example.jetpackcomposelectures.week1_2_oop

class Product(var id : Int,
              var name : String,
              var price : Int){

    init {
        println("nesne oluşturuldu")
    }
    //creating functions

    fun GetProduct(){
        println("Id : ${id}")
        println("Ad : ${name}")
        println("Fiyat : ${price}")
    }




}