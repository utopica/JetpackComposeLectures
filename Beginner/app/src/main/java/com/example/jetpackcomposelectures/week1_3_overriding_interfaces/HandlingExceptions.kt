package com.example.jetpackcomposelectures.week1_3_overriding_interfaces

fun main() {

    // errors have two different types compile error, runtime error
    val x = 10
    val y = 0

    try{
        println("Result = ${x/y}")

        println("Success")

    }catch(e : Exception){
        println("Zero division error -> $e")
    }
}