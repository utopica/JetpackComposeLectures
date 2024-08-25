package com.example.jetpackcomposelectures.week1_3_overriding_interfaces.oop2

fun main(){
    val animal = Animal()
    val mammal = Mammal()
    val cat = Cat()
    val dog = Dog()

    animal.makeSound()
    mammal.makeSound()
    cat.makeSound()
    dog.makeSound()

    // type control

    if(cat is Mammal){
        println("Cats are mammals")
    }else{
        println("Cats aren't mammals")
    }
}