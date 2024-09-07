package com.example.kisileruygulamasihilt.retrofit

import com.example.kisileruygulamasihilt.data.entity.KisilerCevap
import retrofit2.http.GET

interface KisilerDao {

    //http://kasimadalan.pe.hu/kisiler/tum_kisiler.php
    //http://kasimadalan.pe.hu/ -> baseUrl
    //kisiler/tum_kisiler.php -> apiUrl

    @GET("kisiler/tum_kisiler.php")
    suspend fun kisileriYukle () : KisilerCevap

}