package com.example.jetpackcomposelectures.week4_2_kisiler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.jetpackcomposelectures.week4_2_kisiler.ui.theme.JetpackComposeLecturesTheme
import com.example.jetpackcomposelectures.week4_2_kisiler.uix.viewmodel.AnasayfaViewModel
import com.example.jetpackcomposelectures.week4_2_kisiler.uix.viewmodel.KisiDetayViewModel
import com.example.jetpackcomposelectures.week4_2_kisiler.uix.viewmodel.KisiKayitViewModel
import com.example.jetpackcomposelectures.week4_2_kisiler.uix.views.SayfaGecisleri

class MainActivity : ComponentActivity() {
    val anasayfaViewModel : AnasayfaViewModel by viewModels()
    val kisiKayitViewModel : KisiKayitViewModel by viewModels()
    val kisiDetayViewModel : KisiDetayViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeLecturesTheme {
                SayfaGecisleri(anasayfaViewModel, kisiKayitViewModel, kisiDetayViewModel)
            }
        }
    }
}