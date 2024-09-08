package com.example.jetpackcomposelectures.week4_2_kisiler.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpackcomposelectures.week4_2_kisiler.data.entity.Kisiler

@Database(entities = [Kisiler::class], version = 1)
abstract class Veritabani : RoomDatabase(){

    abstract fun getKisilerDao() : KisilerDao
}