package com.example.jetpackcomposelectures.week1_2_oop

fun main(){
    val result = 5.Extention(4)
    val result2 = 100 Extention2 2

    println("Result : $result")
    println("Result2 : $result2")

}

fun Int.Extention(number : Int) : Int{
    return this * number
    //this-> Int class
    //extention method
}

infix fun Int.Extention2(number : Int) : Int{
    return this / number
    //infix
}