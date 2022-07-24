package com.example.myapplication.presentation.home.main_screen.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.presentation.home.models.NavItem

@Composable
fun DetailNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavItem.Main.route
    ) {
        composable(route = NavItem.Main.route) {
        }
    }
}