package com.example.communalka.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector


sealed class NavigationItem(val title: String, val icon: ImageVector, val route: String) {
    object Home_screen: NavigationItem("Главная", Icons.Rounded.Home, "Home_screen")
    object Plans_screen: NavigationItem("Тариф", Icons.Rounded.List, "Plans_screen")
}


object commonData {
    var Cards by mutableStateOf(listOf<@Composable () -> Unit>())
}

