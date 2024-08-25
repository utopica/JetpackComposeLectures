package com.example.jetpackcomposelectures.week1_2_oop

fun main(){
    //nullable null safety optional

    var message : String? = null

    // Method 1
    println("Method1 : ${message?.uppercase()}")

    message = "Hi"
    // Method 2
    println("Method2 : ${message!!.uppercase()}")

    // Method 3
    if(message != null){
        println("Method2 : ${message.uppercase()}")
    }else{
        println("Null value")
    }

    message = "null"
    // Method 4
    message?.let{
        println("Method3 : ${it.uppercase()}")
    }
}