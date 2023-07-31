package com.juan.fehome.navigation

import com.juan.fehome.R

/**
 * Created by JuanMBV
 */

sealed class AppScreens(val icon: Int, val title: String, val route: String){
    object MainScreen: AppScreens(R.drawable.baseline_home_24, "Home","main_screen")
    object AlliesScreen: AppScreens(R.drawable.ic_allies, "Allies", "allies_screen")
    object InfoScreen: AppScreens(R.drawable.ic_help, "Info", "info_screen")
}
