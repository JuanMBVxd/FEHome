package com.juan.fehome.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        topBar = {TopAppBar(navController)},
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Aqui puedo sobreponer los objetos
            BackgroundHero()
            HeroImage()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ){
                //Contenido
                BuildHero()
                BottomButtons(navController)
            }
        }
    }
}

@Composable
private fun BuildHero(){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(690.dp)
            .padding(start = 6.dp, end = 6.dp, top = 400.dp)
            .clip(shape = RoundedCornerShape(10.dp)),
        color = MaterialTheme.colors.primary,
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // Contenido de la sección 1
            Text(
                text = "Hilda",
                color = MaterialTheme.colors.onPrimary,
                fontSize = 25.sp,
            )
            Text(
                text = "Idle Maiden",
                color = MaterialTheme.colors.onPrimary,
                fontSize = 25.sp,
            )
        }
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.End
        ){
            Text(
                text = "Skills",
                color = MaterialTheme.colors.onPrimary,
                fontSize = 25.sp,
            )
        }
    }
}

@Composable
private fun BottomButtons(navController: NavController){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(57.dp)
            .padding(start = 6.dp, end = 6.dp, top = 2.dp)
            ,
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(

            ){
                Button(
                    onClick = {
                        navController.popBackStack()
                    },
                    modifier = Modifier.padding(end = 10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red, contentColor = Color.White)
                ) {
                    Text("Cancel")
                }
                Button(
                    onClick = {
                        // Aqui ira el query para guardar y retornar a la pantalla anterior
                        navController.popBackStack()
                    },
                    modifier = Modifier.padding(start = 10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
                ) {
                    Text("Save")
                }
            }

        }
    }
}

/**
 * Ya esta la imagen posicionada, nomas seria cuando ya este la base de datos, mandar la url de la imagen
 * al metodo
 */
@Composable
private fun HeroImage(){
    Column(
    ) {
        Image(
            painter = painterResource(R.drawable.img_hero_hilda_full),
            contentDescription = "Fondo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(760.dp)
        )
    }
}

/**
 * // Ya se ve bien el fondo, de esta funcion nadamas habria que cambiar el fondo dependiendo
// del summon suport
 */
@Composable
private fun BackgroundHero(){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(700.dp)
            .clip(shape = RoundedCornerShape(10.dp)),
        color = MaterialTheme.colors.primary,
    ) {
        Column(
        ) {
            // Contenido de la sección 1
            Image(
                painter = painterResource(R.drawable.img_background_hero),
                contentDescription = "Fondo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxHeight()
            )
        }
    }

}

@Composable
private fun TopAppBar(navController: NavController) {
    TopAppBar(
        title = { Text(text = "Hero Build") },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Atras")
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