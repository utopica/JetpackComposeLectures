package com.example.jetpackcomposelectures.week4_2_kisiler.uix

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.jetpackcomposelectures.R
import com.example.jetpackcomposelectures.week4_2_kisiler.data.entity.Kisiler

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(navController: NavController){

    val aramaYapiliyorMu = remember {
        mutableStateOf(false)
    }

    val tf = remember {
        mutableStateOf("")
    }

    var kisilerListesi = remember {
        mutableStateListOf<Kisiler>()
    }

    fun ara(aramaKelimesi : String){
        Log.e("Kişi Ara", aramaKelimesi)
    }

    LaunchedEffect(key1 = true) { //sayfa açıldığında çalışır
        val kisi1 = Kisiler(1, "Ahmet", "1111")
        val kisi2 = Kisiler(2, "Zeynep", "2222")
        val kisi3 = Kisiler(3, "Beyza", "3333")

        kisilerListesi.add(kisi1)
        kisilerListesi.add(kisi2)
        kisilerListesi.add(kisi3)

    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if(aramaYapiliyorMu.value){
                        TextField(value = tf.value, onValueChange = {
                            tf.value = it
                            ara(it)},
                            label = {Text(text = "Ara")},
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.Transparent,
                                focusedLabelColor = Color.White,
                                focusedIndicatorColor = Color.White,
                                unfocusedLabelColor = Color.Black,
                                unfocusedIndicatorColor = Color.White
                            ))
                    }else{
                        Text (text = "Kisiler") }
                    },

                actions = {
                    if(aramaYapiliyorMu.value){
                        IconButton(onClick = {

                            aramaYapiliyorMu.value = false
                            tf.value = ""
                        }) {
                            Icon(painter = painterResource(id = R.drawable.baseline_close_24), contentDescription = "")
                        }
                    }else{
                        IconButton(onClick = {
                            aramaYapiliyorMu.value = true

                        }) {
                            Icon(painter = painterResource(id = R.drawable.baseline_search_24), contentDescription = "")
                        }
                    }

                }
                )},

        floatingActionButton = {
            FloatingActionButton(
                onClick = {navController.navigate("kisiKayitSayfa")},
                content = {
                    Icon(painter = painterResource(id = R.drawable.baseline_add_24), contentDescription = "")
                }
                )
        }

    ) {
        paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,

        ) {
            items(
                count = kisilerListesi.count(),
                itemContent = {
                    val kisi = kisilerListesi[it] //0,1,2
                    Text(text="${kisi.kisi_ad} - ${kisi.kisi_tel}" )
                }

            )
        }
    }
}