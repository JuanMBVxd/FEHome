package com.juan.fehome.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juan.fehome.ui.theme.FEHomeTheme

/**
 * Created by JuanMBV
 * Pantalla pendien
 */

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HeroInfoScreen(){
    FEHomeTheme {
        ContentHeroInfoScreen()
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun ContentHeroInfoScreen(){
    Scaffold (
        topBar = {TopAppBar()}
    ){
        // Columna para dividir la pantalla en secciones
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp) // Esto espacea cada seccion
        ){
            //Contenido
            HeroInfo()
        }
    }
}

@Composable
private fun HeroInfo(){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(700.dp)
            .padding(top = 6.dp, start = 6.dp, end = 6.dp)
            .clip(shape = RoundedCornerShape(10.dp)),
        color = MaterialTheme.colors.primary,
    ) {
        Column(
            modifier = Modifier.padding(10.dp), // Me quede haciendo el padding para acomodar el texto
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Contenido de la sección 1

            // Contenido
        }
    }
}

@Composable
private fun TopAppBar() {
    TopAppBar(
        title = { Text(text = "Hero") },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Buscar")
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun HeroInfoScreenPreview(){
    HeroInfoScreen()
}