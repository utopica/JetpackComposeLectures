package com.example.basekisileruygulamasi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.basekisileruygulamasi.ui.theme.BaseKisilerUygulamasiTheme
import com.example.basekisileruygulamasi.uix.viewmodel.AnasayfaViewModel
import com.example.basekisileruygulamasi.uix.viewmodel.KisiDetayViewModel
import com.example.basekisileruygulamasi.uix.viewmodel.KisiKayitViewModel
import com.example.basekisileruygulamasi.uix.views.SayfaGecisleri
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val anasayfaViewModel: AnasayfaViewModel by viewModels()
    val kisiKayitViewModel: KisiKayitViewModel by viewModels()
    val kisiDetayViewModel: KisiDetayViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaseKisilerUygulamasiTheme {
                SayfaGecisleri(anasayfaViewModel,kisiKayitViewModel,kisiDetayViewModel)
            }
        }
    }
}