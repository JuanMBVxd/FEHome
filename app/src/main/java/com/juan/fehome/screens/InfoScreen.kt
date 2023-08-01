package com.juan.fehome.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

/**
 * Created by JuanMBV
 */

@Composable
fun InfoScreen(navController: NavController){
    TopAppBar()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text("Info Screen")
    }
}

@Composable
private fun TopAppBar() {
    TopAppBar(
        title = { Text(text = "Info", modifier = Modifier.padding(10.dp)) },
        actions = {/*Actions*/}
    )
}

@Preview(showBackground = true)
@Composable
fun InfoScreenPreview(){
    val navController = rememberNavController()
    InfoScreen(navController)
}