package com.juan.fehome.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.juan.fehome.screens.*

/**
 * Created by JuanMBV
 */

@Composable
fun AppNavigation(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = AppScreens.MainScreen.route
    ){
        composable(AppScreens.MainScreen.route){
            MainScreen()
        }
        composable(AppScreens.AlliesScreen.route){
            AlliesScreen()
        }
        composable(AppScreens.InfoScreen.route){
            InfoScreen()
        }
    }
}