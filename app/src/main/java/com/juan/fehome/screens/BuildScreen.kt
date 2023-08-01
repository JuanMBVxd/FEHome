package com.juan.fehome.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.juan.fehome.R
import com.juan.fehome.ui.theme.FEHomeTheme

/**
 * Created by JuanMBV
 */

@Composable
fun BuildScreen(navController: NavController){
    FEHomeTheme{
        ContentBuildScreen(navController)
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun ContentBuildScreen(navController: NavController){
    Scaffold(
        topBar = {TopAppBar(navController)}
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp) // Esto espacea cada seccion
        ){
            //Contenido
            BackgroundHero()
        }
    }
}

@Composable
private fun BackgroundHero(){
    Image(
        painter = painterResource(R.drawable.img_background_hero),
        contentDescription = "Fondo",
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
private fun TopAppBar(navController: NavController) {
    TopAppBar(
        title = { Text(text = "Hero Details") },
        navigationIcon = {
            IconButton(onClick = {
                // aqui mero
                navController.popBackStack()
            }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Buscar")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun BuildScreenPreview(){
    val navController = rememberNavController()
    BuildScreen(navController)
}