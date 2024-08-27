package com.example.jetpackcomposelectures.week1_3_overriding_interfaces.oop2

class MyClass : MyInterface {

    override val variable: Int = 10

    override fun method1() {
        println("Method1 is executed")
    }

    override fun method2(): String {
        return("Method2 is executed")
    }

}