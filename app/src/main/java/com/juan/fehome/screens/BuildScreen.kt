package com.juan.fehome.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.juan.fehome.DataBase.DAO.HeroDao
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
    // Estado booleano para controlar el switch
    var isSummonSupport by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {TopAppBar(navController)},
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Aqui puedo sobreponer los objetos
            BackgroundHero(isSummonSupport) // Pasar el estado del Switch al Composable del fondo
            HeroImage()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ){
                //Contenido
                BuildHero(isSummonSupport, onSwitchChanged = { isSummonSupport = it }) // Pasar el estado del Switch al Composable de BuildHero
                BottomButtons(navController)
            }
        }
    }
}

@Composable
private fun BuildHero(isSummonSupport: Boolean, onSwitchChanged: (Boolean) -> Unit) {
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

            HeroSelection()
        }
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "Skills",
                color = MaterialTheme.colors.onPrimary,
                fontSize = 25.sp,
            )
            SwitchSummonSupport(isSummonSupport, onSwitchChanged) // Pasar el estado del Switch al Composable de los Switches
        }
    }
}

@Composable
fun SwitchSummonSupport(isSummonSupport: Boolean, onSwitchChanged: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.padding(3.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Summon support")
        Switch(
            checked = isSummonSupport,
            onCheckedChange = onSwitchChanged
        )
    }
}


/**
 * ================================================================================================
 */
@Composable
fun HeroSelection() {
    val heroNames = HeroDao.getHeroNames() // Obtener la lista de nombres de héroes

    val text = remember { mutableStateOf("Hero") } // initial value
    val isOpen = remember { mutableStateOf(false) } // initial value
    val openCloseOfDropDownList: (Boolean) -> Unit = {
        isOpen.value = it
    }
    val userSelectedString: (String) -> Unit = {
        text.value = it
    }

    Box {
        Column {
            OutlinedTextField(
                value = text.value,
                onValueChange = { text.value = it },
                label = { Text(text = "") },
                modifier = Modifier.width(150.dp),

            )
            DropDownList(
                requestToOpen = isOpen.value,
                heroNames = heroNames,
                openCloseOfDropDownList,
                userSelectedString
            )
        }
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Transparent)
                .padding(10.dp)
                .clickable(
                    onClick = { isOpen.value = true }
                )
        )
    }
}

@Composable
fun DropDownList(
    requestToOpen: Boolean = false,
    heroNames: List<String>,
    request: (Boolean) -> Unit,
    selectedString: (String) -> Unit
) {
    DropdownMenu(
        modifier = Modifier.fillMaxWidth(),
        expanded = requestToOpen,
        onDismissRequest = { request(false) },
    ) {
        heroNames.forEach { name ->
            DropdownMenuItem(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    request(false)
                    selectedString(name)
                }
            ) {
                Text(name, modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                    textAlign = TextAlign.Start)
            }
        }
    }
}

/**
 * ================================================================================================
 */


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
 * Ya esta la imagen mas o menos posicionada, nomas seria cuando ya este la base de datos, mandar la url de la imagen
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
private fun BackgroundHero(isSummonSupport: Boolean){
    // Verificar el estado del Switch y establecer el fondo segun el valor
    val backgroundResource = if (isSummonSupport) {
        R.drawable.img_background_hero_supported // Recurso de imagen para Summon Support activado
    } else {
        R.drawable.img_background_hero // Recurso de imagen para Summon Support desactivado
    }

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
                painter = painterResource(backgroundResource),
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