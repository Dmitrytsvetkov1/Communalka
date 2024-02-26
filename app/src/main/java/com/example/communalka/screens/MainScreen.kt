package com.example.communalka.screens

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.communalka.components.BottomNavigationBar
import com.example.communalka.controllers.NavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen (){

    val navController = rememberNavController()

    Scaffold (
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ){
        NavGraph(navHostController = navController)
    }
}