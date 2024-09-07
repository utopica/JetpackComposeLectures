package com.example.jetpackcomposelectures.week4_2_kisiler.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.jetpackcomposelectures.week4_2_kisiler.data.entity.Kisiler

@Dao
interface KisilerDao {

    @Query("SELECT * FROM kisiler")
    suspend fun kisileriYukle() : List<Kisiler>

    @Insert
    suspend fun kaydet(kisi: Kisiler)

    @Update
    suspend fun guncelle(kisi: Kisiler)

    @Delete
    suspend fun sil(kisi: Kisiler)

    @Query(" SELECT * FROM kisiler WHERE kisi_ad like '%' || :aramaKelimesi || '%' ")
    suspend fun ara(aramaKelimesi:String) : List<Kisiler>
}

//dao database access object