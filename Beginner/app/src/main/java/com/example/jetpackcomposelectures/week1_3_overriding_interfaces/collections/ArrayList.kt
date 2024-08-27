package com.example.jetpackcomposelectures.week1_3_overriding_interfaces.collections

fun main(){
    // defining an arraylist

    val fruits = ArrayList<String>()

    // adding data

    fruits.add("Apple")
    fruits.add("Orange")
    fruits.add("Cherry")
    fruits.add("Strawberry")

    println(fruits)

    // updating data
    fruits[1] = "Banana"

    println(fruits)

    // insert
    fruits.add(1,"Kiwi")

    println(fruits)

    // reading data

    println(fruits.get(0))

    println(fruits[2])

    println(fruits.count())
    println(fruits.size)

    for(fruit in fruits){
        println("result : $fruit")
    }
    // iterating
    for((index,fruit) in fruits.withIndex()){
        println("$index : $fruit")
    }

    // deleting data
    fruits.removeAt(2)
    println(fruits)

    fruits.clear()
    println(fruits)


}