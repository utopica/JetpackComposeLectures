package com.example.jetpackcomposelectures.week4_3_movies.uix.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposelectures.week4_3_movies.data.entity.Movies
import com.google.gson.Gson

@Composable
fun PageNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "homepage"){
        composable("homepage"){
            HomePage(navController)
        }

        composable(
            "detailpage/{movie}",
            arguments = listOf(
                navArgument("movie"){type = NavType.StringType}
            )
            ){

            val json = it.arguments?.getString("movie")

            val nesne = Gson().fromJson(json, Movies::class.java)

            DetailPage(nesne)
        }
    }
}