package com.juan.fehome.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juan.fehome.R
import com.juan.fehome.ui.theme.FEHomeTheme

/**
 * Created by JuanMBV
 */

@Composable
fun AlliesScreen(){
    FEHomeTheme {
        ContentAlliesScreen()
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun ContentAlliesScreen(){
    Scaffold(
        topBar = {TopAppBar()},
        bottomBar = { BottomAlliesBar()}
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp) // Esto espacea cada seccion
        ){
            // Metodos con el contenido de cada seccion
            ContentAllies()
        }
    }
}

@Composable
private fun ContentAllies(){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(270.dp)
            .padding(top = 6.dp, start = 6.dp, end = 6.dp)
            .clip(shape = RoundedCornerShape(10.dp)),
        color = MaterialTheme.colors.primary,
    ) {
        Column(
            modifier = Modifier.padding(10.dp), // Me quede haciendo el padding para acomodar el texto
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Contenido de la sección 1
            Text(
                text = "Allies",
                color = MaterialTheme.colors.onPrimary,
                fontSize = 25.sp,
            )
        }
    }
}

@Composable
private fun TopAppBar() {
    TopAppBar(
        title = { Text(text = "Allies", modifier = Modifier.padding(10.dp)) },
        actions = {/*Actions*/ }
    )
}

@Composable
private fun BottomAlliesBar() {
    BottomAppBar(
        modifier = Modifier
            .padding(6.dp)
            .clip(shape = RoundedCornerShape(10.dp)),
    ) {
        // Botones con imágenes en la BottomAppBar
        IconButton(onClick = { /* Acción del botón de Inicio */ }) {
            Icon(
                painter = painterResource(R.drawable.ic_delete_24dp),
                contentDescription = "Delete",
                modifier = Modifier.padding(start = 120.dp)
            )
        }
        IconButton(onClick = { /* Acción del botón de Favorito */ }) {
            Icon(
                painter = painterResource(R.drawable.ic_add_24dp),
                contentDescription = "Add",
                modifier = Modifier.padding(start = 50.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlliesScreenPreview(){
    AlliesScreen()
}