package com.example.jetpackcomposelectures.week4_2_kisiler.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.jetpackcomposelectures.week4_2_kisiler.data.entity.Kisiler

@Dao
interface KisilerDao {

    @Query("SELECT * FROM kisiler")

    suspend fun kisileriYukle() : List<Kisiler>

    @Insert
    suspend fun kaydet(kisiler: Kisiler)
}

//dao database access object