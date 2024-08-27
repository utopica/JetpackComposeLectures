package com.example.jetpackcomposelectures.week1_3_overriding_interfaces.collections

fun main(){

    val fruits = HashSet<String>()

    fruits.add("Apple")
    fruits.add("Orange")
    fruits.add("Cherry")
    fruits.add("Strawberry")
    fruits.add("Strawberry") // You can't add the same element more than once.
    println(fruits)

    println(fruits.size)
    println(fruits.elementAt(2))

    for((index,fruit) in fruits.withIndex()){
        println("$index : $fruit")
    }

    fruits.remove("Apple")
    println(fruits)

    fruits.clear()
    println(fruits)
}