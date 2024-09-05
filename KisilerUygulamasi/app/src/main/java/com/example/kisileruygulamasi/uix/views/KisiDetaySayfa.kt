package com.example.jetpackcomposelectures.week4_2_kisiler.uix.views

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposelectures.week4_2_kisiler.data.entity.Kisiler
import com.example.jetpackcomposelectures.week4_2_kisiler.uix.viewmodel.KisiDetayViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KisiDetaySayfa(gelenKisi:Kisiler, kisiDetayViewModel: KisiDetayViewModel){

    val tfKisiAd = remember {
        mutableStateOf("")
    }
    val tfKisiTel = remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = true) {
        tfKisiAd.value = gelenKisi.kisi_ad
        tfKisiTel.value = gelenKisi.kisi_tel
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text (text = "Kisi Detay") }) }
    ) {
            paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            TextField(value = tfKisiAd.value,
                onValueChange = { tfKisiAd.value = it },
                label = { Text(text = "Kisi Ad")}
            )

            TextField(value = tfKisiTel.value,
                onValueChange = { tfKisiTel.value = it },
                label = { Text(text = "Kisi Tel")}
            )

            Button(
                modifier = Modifier.size(250.dp, 50.dp),
                onClick = { kisiDetayViewModel.guncelle(gelenKisi.kisi_id, tfKisiAd.value, tfKisiTel.value) }) {
                Text(text = "Guncelle")
            }
        }
    }
}