package com.example.jetpackcomposelectures.week1_2_oop

class Functions {
    //void, return

    lateinit var text: String //i will pass a value later

    //primitive de illa ki tanımlamamız lazım
    var number = 0

    fun selamla(){

        val result = "Hi"

        println("sonuc ${result}")
    }

    fun sayHi3(name : String){

        val result3 = "Hi $name"

        println(result3)
    }

    fun sayHi2(name : String){

        val result2 = "Hi $name"

        println(result2)
    }

    fun multiply(num1:Int, num2:Int){
        println(num1 * num2)
    }
    fun multiply2(num1:Double, num2:Double){
        println(num1 * num2)
    }
    fun multiply3(num1:String, num2:String){
        println("$num1 * $num2")
    }
}