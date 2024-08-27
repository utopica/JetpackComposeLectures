package com.example.jetpackcomposelectures.week4_3_movies.uix.views

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposelectures.week4_3_movies.data.entity.Movies

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPage(movie:Movies){
    Scaffold (
        topBar = { CenterAlignedTopAppBar(title = { Text(text = movie.ad) } ) }

    ){ paddingValues ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            val activity = (LocalContext.current as Activity)

            Image(
                bitmap = ImageBitmap.imageResource(
                    id = activity.resources.getIdentifier(movie.resim,
                        "drawable", activity.packageName)),
                contentDescription = "" , Modifier.size(200.dp, 300.dp))

            Text(text = "${movie.fiyat} ₺", fontSize = 50.sp)
        }
    }
}