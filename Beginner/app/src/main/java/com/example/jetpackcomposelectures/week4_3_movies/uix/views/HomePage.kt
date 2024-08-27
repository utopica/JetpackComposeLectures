package com.example.jetpackcomposelectures.week4_3_movies.uix.views

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackcomposelectures.R
import com.example.jetpackcomposelectures.week4_3_movies.data.entity.Movies
import com.google.gson.Gson
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController){

    val movieList = remember { mutableStateListOf<Movies>()}

    val scope = rememberCoroutineScope()

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        val movie1 = Movies(1, "Django", "django",24.0)
        val movie2 = Movies(1, "Interstellar", "interstellar",32.0)
        val movie3 = Movies(1, "Inception", "inception",18.0)
        val movie4 = Movies(1, "The Hateful Eight", "thehatefuleight",50.0)
        val movie5 = Movies(1, "The Pianist", "thepianist",43.0)
        val movie6 = Movies(1, "Anadoluda", "anadoluda",29.0)
        movieList.add(movie1)
        movieList.add(movie2)
        movieList.add(movie3)
        movieList.add(movie4)
        movieList.add(movie5)
        movieList.add(movie6)

    }
    Scaffold (
        topBar = { CenterAlignedTopAppBar(title = { Text(text = "Filmler") } ) },

        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }

    ){ paddingValues ->
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            columns = GridCells.Fixed(count = 2) //2li hücre
        ) {
            items(
                count = movieList.count(),
                itemContent = {
                    val movie = movieList[it] //itemcontent sırayla veri getirecek
                    Card (
                        modifier = Modifier.padding(all = 5.dp)
                    ){
                        Column (
                            modifier = Modifier.fillMaxWidth() //fillmaxheight yapsaydın sonsuz scroll olurdu
                                .clickable {
                                    val movieJson = Gson().toJson(movie)

                                    navController.navigate("detailpage/$movieJson")
                                }
                        ) {
                            val activity = (LocalContext.current as Activity)

                            Image(
                                bitmap = ImageBitmap.imageResource(
                                    id = activity.resources.getIdentifier(movie.resim,
                                        "drawable", activity.packageName)),
                                contentDescription = "" , Modifier.size(200.dp, 300.dp))

                            Row (
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Text(text = "${movie.fiyat} ₺", fontSize = 24.sp)

                                Button(onClick = {
                                    //snackbar
                                    scope.launch {
                                        snackbarHostState.showSnackbar(message = "${movie.ad} sepete eklendi")
                                    }
                                }) {
                                    Text(text = "Sepet")
                                }
                            }

                        }
                    }
                }
            )
        }
    }
}