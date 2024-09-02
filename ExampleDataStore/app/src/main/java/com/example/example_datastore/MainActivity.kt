package com.example.example_datastore

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.example_datastore.ui.theme.Example_DataStoreTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Example_DataStoreTheme {

                Anasayfa()
            }
        }
    }
}

@Composable
fun Anasayfa() {

    val context = LocalContext.current

    val appPref = AppPref(context)

    val sayac = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = true) {
        CoroutineScope(Dispatchers.Main).launch { //arayüze yakın main, veritabanına yakın IO
            // Kayıt

            appPref.kayitAd("Ahmet") //suspend fonksiyonlar coroutine scope içerinde çalıştırılmalı
            appPref.kayitBoy(1.82)
            appPref.kayitYas(30)
            appPref.kayitBekar(false)

            val liste = HashSet<String>()
            liste.add("Ali")
            liste.add("Ece")

            appPref.kayitListe(liste)

            // Silme
            // appPref.silAd()

            // Okuma
            val gelenAd = appPref.okuAd()
            val gelenYas = appPref.okuYas()
            val gelenBoy = appPref.okuBoy()
            val gelenBekar = appPref.okuBekar()
            val gelenListe = appPref.okuListe()

            Log.e("Gelen Ad", gelenAd)
            Log.e("Gelen Yas", gelenYas.toString())
            Log.e("Gelen Boy", gelenBoy.toString())
            Log.e("Gelen Bekar", gelenBekar.toString())

            if(gelenListe != null){
                for(a in gelenListe){
                    Log.e("Gelen Liste", a)
                }
            }

            // Sayac Uygulaması

            var gelenSayac = appPref.okuSayac()
            sayac.value = ++gelenSayac
            appPref.kayitSayac(gelenSayac)
        }
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Açılış Sayısı : ${sayac.value} ", fontSize = 32.sp)
    }
}