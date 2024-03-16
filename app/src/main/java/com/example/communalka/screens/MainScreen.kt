package com.example.communalka.screens

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.communalka.components.BottomNavigationBar
import com.example.communalka.controllers.NavGraph




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen (){

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold (
        bottomBar = {
            if (currentRoute == "Home_screen" || currentRoute == "Plans_screen")
                BottomNavigationBar(navController)
        }
    ){
        NavGraph(navHostController = navController)
    }
}
