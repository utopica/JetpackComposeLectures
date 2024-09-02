package com.example.example_datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class AppPref ( var context : Context ){

    //context clasına extention ekleme

    val Context.datasource : DataStore<Preferences> by preferencesDataStore("bilgiler")

    companion object{
        val AD_KEY = stringPreferencesKey("AD")
        val YAS_KEY = intPreferencesKey("YAS")
        val BOY_KEY = doublePreferencesKey("BOY")
        val BEKAR_KEY = booleanPreferencesKey("BEKAR")
        val LISTE_KEY = stringSetPreferencesKey("LISTE")
        val SAYAC_KEY = intPreferencesKey("SAYAC")

    }

    suspend fun kayitAd ( ad : String ) {
        context.datasource.edit {
            it[AD_KEY] = ad
        }
    }

    suspend fun okuAd() : String {
        val preference = context.datasource.data.first()

        return preference[AD_KEY] ?: "Isim Yok"
    }

    suspend fun silAd(){
        context.datasource.edit {
            it.remove(AD_KEY)
        }
    }

    suspend fun silSayac(){
        context.datasource.edit {
            it.remove(SAYAC_KEY)
        }
    }

    suspend fun kayitYas ( yas : Int ) {
        context.datasource.edit {
            it[YAS_KEY] = yas
        }
    }

    suspend fun okuYas() : Int {
        val preference = context.datasource.data.first()

        return preference[YAS_KEY] ?: 0
    }

    suspend fun kayitBoy ( boy : Double ) {
        context.datasource.edit {
            it[BOY_KEY] = boy
        }
    }

    suspend fun okuBoy() : Double {
        val preference = context.datasource.data.first()

        return preference[BOY_KEY] ?: 0.0
    }

    suspend fun kayitBekar ( bekar : Boolean ) {
        context.datasource.edit {
            it[BEKAR_KEY] = bekar
        }
    }

    suspend fun okuBekar() : Boolean {
        val preference = context.datasource.data.first()

        return preference[BEKAR_KEY] ?: false
    }

    suspend fun kayitListe ( liste : Set<String> ) {
        context.datasource.edit {
            it[LISTE_KEY] = liste
        }
    }

    suspend fun okuListe() : Set<String>? {
        val preference = context.datasource.data.first()

        return preference[LISTE_KEY]
    }

    suspend fun kayitSayac ( sayac : Int ) {
        context.datasource.edit {
            it[SAYAC_KEY] = sayac
        }
    }

    suspend fun okuSayac() : Int {
        val preference = context.datasource.data.first()

        return preference[SAYAC_KEY] ?: 0
    }
}

// context andırid ile ilgili bir parça yerleştirmemizi sağlar