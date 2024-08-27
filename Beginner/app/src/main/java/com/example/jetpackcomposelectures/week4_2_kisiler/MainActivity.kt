package com.example.jetpackcomposelectures.week4_2_kisiler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.jetpackcomposelectures.week4_2_kisiler.ui.theme.JetpackComposeLecturesTheme
import com.example.jetpackcomposelectures.week4_2_kisiler.uix.SayfaGecisleri

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeLecturesTheme {
                SayfaGecisleri()
            }
        }
    }
}

