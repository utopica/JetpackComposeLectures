package com.example.jetpackcomposelectures.week3_1_example_voyage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cafe.adriel.voyager.navigator.Navigator
import com.example.jetpackcomposelectures.week3_1_example_voyage.ui.theme.JetpackComposeLecturesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeLecturesTheme {
                //Navigator(screen = Anasayfa())
                BottomBarSayfa()
            }
        }
    }
}
