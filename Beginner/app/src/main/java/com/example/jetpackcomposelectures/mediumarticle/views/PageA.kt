package com.example.jetpackcomposelectures.mediumarticle.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.jetpackcomposelectures.mediumarticle.data.entity.Users
import com.example.jetpackcomposelectures.mediumarticle.ui.theme.ButtonColor

class PageA : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val name = "John"
        val surname = "Doe"

        Scaffold (
            topBar = {
                CenterAlignedTopAppBar(title = { Text(text = "Page A", fontSize = 28.sp) })
            }
        ){
            paddingValues ->

            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Button(
                    onClick = {
                        val user = Users(name, surname)
                        navigator.push(PageB(user))
                        },
                    modifier = Modifier.size(150.dp, 50.dp),
                    colors = ButtonDefaults.buttonColors(ButtonColor)
                ) {
                    Text(text = "Go to Page B", fontSize = 17.sp)
                }
            }
        }
    }
}