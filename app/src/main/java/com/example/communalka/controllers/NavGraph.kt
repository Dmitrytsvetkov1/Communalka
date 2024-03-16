package com.example.communalka.controllers

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.communalka.screens.AddScreen
import com.example.communalka.screens.HomeScreen
import com.example.communalka.screens.PlansScreen

@Composable
fun NavGraph (navHostController: NavHostController){
    NavHost(
        navController = navHostController,
        startDestination = "Home_screen"
    ){
        composable("Plans_screen"){
            PlansScreen(navHostController)
        }
        composable("Home_screen"){
            HomeScreen()
        }
        composable("Add_screen"){
            AddScreen(navHostController)
        }
    }
}