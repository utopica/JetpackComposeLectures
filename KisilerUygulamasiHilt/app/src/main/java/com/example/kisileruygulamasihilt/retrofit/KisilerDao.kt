package com.example.kisileruygulamasihilt.retrofit

import com.example.kisileruygulamasihilt.data.entity.CRUDCevap
import com.example.kisileruygulamasihilt.data.entity.KisilerCevap
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KisilerDao {

    //http://kasimadalan.pe.hu/kisiler/tum_kisiler.php
    //http://kasimadalan.pe.hu/ -> baseUrl
    //kisiler/tum_kisiler.php -> apiUrl

    @GET("kisiler/tum_kisiler.php")
    suspend fun kisileriYukle() : KisilerCevap

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    suspend fun kaydet(@Field("kisi_ad") kisi_ad:String,
                       @Field("kisi_tel") kisi_tel:String) : CRUDCevap

}