package com.example.jetpackcomposelecturesmvvm

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MathRepository {

    //data source yönetir. data source'daki fonksiyonları çalıştırır. repositoryden dsource erişimi olmalı

    var mdatasource = MathDataSource() //instance

    suspend fun topla(alinanSayi1: String, alinanSayi2: String) : String {
        return mdatasource.topla(alinanSayi1, alinanSayi2)
    }


    // modern way

    suspend fun carp(alinanSayi1: String, alinanSayi2: String) : String = mdatasource.carp(alinanSayi1, alinanSayi2)

}