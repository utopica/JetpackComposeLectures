package com.example.jetpackcomposelectures.week3_1_example_widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KullaniciEtkilesimiSayfa(){

    val scope = rememberCoroutineScope() //asenkron arayüzle uyumlu çalışan yapı

    val snackbarHostState = remember {
        SnackbarHostState()
    }

    val acilisKontrol = remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Kullanıcı Etkileşimi") }) },

        snackbarHost = {SnackbarHost(hostState = snackbarHostState)
        {
            Snackbar(snackbarData = it,
                containerColor = Color.White,
                contentColor = Color.Black,
                actionColor = Color.Red)
        }}
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                onClick = { scope.launch {
                    val sb = snackbarHostState.showSnackbar("Silmek ister misin?", "Evet")

                    if(sb == SnackbarResult.ActionPerformed){
                        snackbarHostState.showSnackbar("Silindi")
                    }

                } }) {
                Text(text = "Snackbar")
            }

            Button(
                onClick = {
                    acilisKontrol.value = true
                }) {
                Text(text = "Alert")

                if(acilisKontrol.value){
                    AlertDialog(
                        onDismissRequest = { acilisKontrol.value = false},
                        confirmButton = {
                            OutlinedButton(
                                onClick = {

                                    acilisKontrol.value = false

                                    scope.launch {
                                        snackbarHostState.showSnackbar("Tamam seçildi")

                                    }
                                }) { Text(text = "Tamam")
                            }
                        },
                        dismissButton = {
                            OutlinedButton(
                                onClick = {

                                    acilisKontrol.value = false

                                    scope.launch {
                                        snackbarHostState.showSnackbar("İptal seçildi")

                                    }

                                }) { Text(text = "İptal")
                            }
                        },
                        title = { Text(text = "Başlık")},
                        text = { Text(text = "Mesaj")}
                    
                    )
                }
            }
        }
    }
}