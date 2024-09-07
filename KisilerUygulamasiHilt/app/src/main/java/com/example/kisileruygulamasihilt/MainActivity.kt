package com.example.kisileruygulamasihilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kisileruygulamasihilt.ui.theme.KisilerUygulamasiHiltTheme
import com.example.kisileruygulamasihilt.uix.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasihilt.uix.viewmodel.KisiDetayViewModel
import com.example.kisileruygulamasihilt.uix.viewmodel.KisiKayitViewModel
import com.example.kisileruygulamasihilt.uix.views.SayfaGecisleri
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
            KisilerUygulamasiHiltTheme {
                SayfaGecisleri(anasayfaViewModel,kisiKayitViewModel,kisiDetayViewModel)
            }
        }
    }
}

