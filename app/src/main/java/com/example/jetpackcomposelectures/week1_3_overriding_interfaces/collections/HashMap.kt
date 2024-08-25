package com.example.jetpackcomposelectures.week1_3_overriding_interfaces.collections

fun main(){
    //swift dictionary, json
    //value -> any her türden değeri alır

    var iller = HashMap<Int,String>()

    iller.put(16,"Ankara")
    iller[34] = "İstanbul"
    println(iller)

    println(iller[16])
    println(iller.get(34))

    println(iller.size)

    for((key, value) in iller){
        println("$key -> $value")
    }

    iller.remove(34)

    iller.put(41, "Kocaeli")

    iller.clear()
}