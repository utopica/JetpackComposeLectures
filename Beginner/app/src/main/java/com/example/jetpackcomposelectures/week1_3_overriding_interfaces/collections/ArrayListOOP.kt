package com.example.jetpackcomposelectures.week1_3_overriding_interfaces.collections

fun main(){
    val food1 = Foods(100, "Baklava", 400)
    val food2 = Foods(101, "Meatball", 600)
    val food3 = Foods(102, "Kebap", 800)
    val food4 = Foods(103, "Pasta", 500)

    var foodList = ArrayList<Foods>()
    foodList.add(food1)
    foodList.add(food2)
    foodList.add(food3)
    foodList.add(food4)

    println("----------Default State----------")

    for(food in foodList){
        println("${food.id}. ${food.name} : ${food.price} ₺")
    }

    println("----------filter 1----------")

    val filter1 = foodList.filter { it.price > 400 && it.price<800}
    // it => x.price

    for(food in filter1){
        println("${food.id}. ${food.name} : ${food.price} ₺")
    }

    println("----------filter 2----------")

    val filter2 = foodList.filter {it.name.contains("a")}

    for(food in filter2){
        println("${food.id}. ${food.name} : ${food.price} ₺")
    }

    println("----------filter 3----------")

    val filter3 = foodList.sortedWith(compareBy { it.price }) //assend asc

    for(food in filter3){
        println("${food.id}. ${food.name} : ${food.price} ₺")
    }

    println("----------filter 4----------")

    val filter4 = foodList.sortedWith(compareByDescending { it.price }) //descend dsc

    for(food in filter4){
        println("${food.id}. ${food.name} : ${food.price} ₺")
    }

    println("----------filter 5----------")

    val filter5 = foodList.sortedWith(compareByDescending { it.name }) //assend asc

    for(food in filter5){
        println("${food.id}. ${food.name} : ${food.price} ₺")
    }




}