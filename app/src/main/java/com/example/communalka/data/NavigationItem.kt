package com.example.communalka.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.List
import androidx.compose.ui.graphics.vector.ImageVector


sealed class NavigationItem(val title: String, val icon: ImageVector, val route: String) {
    object Home_screen: NavigationItem("Home", Icons.Rounded.Home, "Home_screen")
    object Plans_screen: NavigationItem("Plans", Icons.Rounded.List, "Plans_screen")
}
