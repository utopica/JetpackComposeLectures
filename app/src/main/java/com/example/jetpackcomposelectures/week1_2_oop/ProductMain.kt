package com.example.jetpackcomposelectures.week1_2_oop

fun main(){
    val product1 = Product(1,"TV",20000)

    product1.name = "Laptop"

    val product2 = Product(2,"Watch",3500)

    product1.GetProduct()

    product2.GetProduct()

    val product3 = Product(3,"Necklace",10000)

    product3.GetProduct()
}