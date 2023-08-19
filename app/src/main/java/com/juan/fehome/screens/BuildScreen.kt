package com.juan.fehome.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.juan.fehome.R
import com.juan.fehome.screens.HeroDao.getHeroInfo
import com.juan.fehome.ui.theme.FEHomeTheme

/**
 * Created by JuanMBV
 */

@Composable
fun BuildScreen(navController: NavController, context: Context){
    FEHomeTheme{
        ContentBuildScreen(navController, context)
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun ContentBuildScreen(navController: NavController, context: Context){
    // Estado booleano para controlar el switch
    var isSummonSupport by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("Hero") }

    val hero = getHeroInfo(text)

    Scaffold(
        topBar = {TopAppBar(navController)},
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Aqui puedo sobreponer los objetos
            BackgroundHero(isSummonSupport) // Pasar el estado del Switch al Composable del fondo
            HeroImage(hero, context)

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ){
                //Contenido
                BuildHero(isSummonSupport, onSwitchChanged = { isSummonSupport = it }, context, text, { newValue -> text =
                    newValue as String
                })
                // Pasar el estado del Switch al Composable de BuildHero
                BottomButtons(navController)
            }
        }
    }
}

@Composable
private fun BuildHero(
    isSummonSupport: Boolean,
    onSwitchChanged: (Boolean) -> Unit,
    context: Context,
    text: String,
    newValue: (Any) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(585.dp)
            .padding(start = 6.dp, end = 6.dp, top = 300.dp)
            .clip(shape = RoundedCornerShape(10.dp)),
        color = MaterialTheme.colors.primary,
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // Contenido de la sección 1
            Row (
                modifier = Modifier.padding(start = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                 // initial value
                HeroSelection(text, newValue)
                /**Aqui despues se debe de mandar el tipo de arma y el tipo movimiento con un query*/
                TypeAndMovement(context)
            }

            LvlAndMerges()
            DracoFlawers()
            HeroStats(text)
        }
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.End
        ) {
            SwitchSummonSupport(isSummonSupport, onSwitchChanged) // Pasar el estado del Switch al Composable de los Switches
            /**Aqui van las funciones de las skills*/
            Weapon()
            Assist()
            Special()
            PassiveA()
            PassiveB()
            PassiveC()
            PassiveS()
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

@Composable
fun Weapon() {
    val weapons = listOf("Weapon 1", "Weapon 2", "Weapon 3", "Weapon 4")
    var weaponSelected by remember { mutableStateOf("Select Weapon") }

    Selector(
        iconResId = R.drawable.img_weapon_icon,
        iconResId2 = null,
        items = weapons,
        selected = weaponSelected,
        onItemSelected = { weaponSelected = it }
    )
}

@Composable
fun Assist() {
    val assists = listOf("Assist 1", "Assist 2", "Assist 3", "Assist 4")
    var assistSelected by remember { mutableStateOf("Select Assist") }

    Selector(
        iconResId = R.drawable.img_assist_icon,
        iconResId2 = null,
        items = assists,
        selected = assistSelected,
        onItemSelected = { assistSelected = it }
    )
}

@Composable
fun Special() {
    val specials = listOf("Special 1", "Special 2", "Special 3", "Special 4")
    var specialSelected by remember { mutableStateOf("Select Special") }

    Selector(
        iconResId = R.drawable.img_special_icon,
        iconResId2 = null,
        items = specials,
        selected = specialSelected,
        onItemSelected = { specialSelected = it }
    )
}

@Composable
fun PassiveA() {
    val passivesA = listOf("Passive A 1", "Passive A 2", "Passive A 3", "Passive A 4")
    var passiveASelected by remember { mutableStateOf("Select Passive A") }

    Selector(
        iconResId = R.drawable.img_skill_none_icon,
        iconResId2 = R.drawable.img_slot_a_icon,
        items = passivesA,
        selected = passiveASelected,
        onItemSelected = { passiveASelected = it }
    )
}

@Composable
fun PassiveB() {
    val passivesB = listOf("Passive B 1", "Passive B 2", "Passive B 3", "Passive B 4")
    var passiveBSelected by remember { mutableStateOf("Select Passive B") }

    Selector(
        iconResId = R.drawable.img_skill_none_icon,
        iconResId2 = R.drawable.img_slot_b_icon,
        items = passivesB,
        selected = passiveBSelected,
        onItemSelected = { passiveBSelected = it }
    )
}

@Composable
fun PassiveC() {
    val passivesC = listOf("Passive C 1", "Passive C 2", "Passive C 3", "Passive C 4")
    var passiveCSelected by remember { mutableStateOf("Select Passive C") }

    Selector(
        iconResId = R.drawable.img_skill_none_icon,
        iconResId2 = R.drawable.img_slot_c_icon,
        items = passivesC,
        selected = passiveCSelected,
        onItemSelected = { passiveCSelected = it }
    )
}

@Composable
fun PassiveS() {
    val passivesS = listOf("Passive S 1", "Passive S 2", "Passive S 3", "Passive S 4")
    var passiveSSelected by remember { mutableStateOf("Select Passive S") }

    Selector(
        iconResId = R.drawable.img_skill_none_icon,
        iconResId2 = R.drawable.img_slot_seal_icon,
        items = passivesS,
        selected = passiveSSelected,
        onItemSelected = { passiveSSelected = it }
    )
}

@Composable
fun Selector(
    iconResId: Int,
    iconResId2: Int?,
    items: List<String>,
    selected: String,
    onItemSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier.padding(start = 5.dp).height(30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(27.dp)
        ) {
            // Imagen inferior
            Image(
                painter = painterResource(iconResId),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            if(iconResId2 != null){
                // Imagen superior superpuesta
                Image(
                    painter = painterResource(iconResId2),
                    contentDescription = "Overlay Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.align(Alignment.BottomEnd)
                )
            }
        }

        var isOpen by remember { mutableStateOf(false) }

        Column {
            Button(
                onClick = { isOpen = true },
                content = { Text(selected) },
                elevation = ButtonDefaults.elevation(0.dp, 0.dp),
                modifier = Modifier
                    .width(170.dp)
                    .height(37.dp)
            )

            DropdownMenu(
                expanded = isOpen,
                onDismissRequest = { isOpen = false },
                modifier = Modifier.width(170.dp)
            ) {
                items.forEach { option ->
                    DropdownMenuItem(onClick = {
                        onItemSelected(option)
                        isOpen = false
                    }) {
                        Text(option)
                    }
                }
            }
        }
    }
}

@Composable
fun TypeAndMovement(context: Context){
    val imageName = "img_axe_icon"
    val imagePainter = painterResource(id = getResourceIdByName(imageName, "drawable", context))


    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(27.dp),
            painter = imagePainter,
            contentDescription = "Type of weapon"
            )

        Image(
            modifier = Modifier.size(20.dp),
            painter = painterResource(R.drawable.img_infantry_icon),
            contentDescription = "Movement type")
    }
}

@SuppressLint("DiscouragedApi")
fun getResourceIdByName(resourceName: String, resourceType: String, context: Context): Int {
    return context.resources.getIdentifier(resourceName, resourceType, context.packageName)
}
@Composable
fun HeroSelection(selectedText: String, onSelectedTextChange: (String) -> Unit) {
    val heroNames = HeroDao.getHeroNames()

    var isOpen by remember { mutableStateOf(false) }

    Column {
        Button(
            onClick = { isOpen = true },
            content = { Text(text = selectedText, textAlign = TextAlign.Center) },
            elevation = ButtonDefaults.elevation(0.dp, 0.dp),
            modifier = Modifier
                .width(150.dp)
                .height(37.dp)
        )

        DropdownMenu(
            expanded = isOpen,
            onDismissRequest = { isOpen = false },
            modifier = Modifier.width(150.dp)
        ) {
            heroNames.forEach { option ->
                DropdownMenuItem(onClick = {
                    onSelectedTextChange(option) // Llamamos a la función para actualizar el valor externo
                    isOpen = false
                }) {
                    Text(option)
                }
            }
        }
    }
}

@Composable
fun LvlAndMerges() {
    DropdownSelection("LVL 40 +", listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"))
}

@Composable
fun DracoFlawers() {
    DropdownSelection("DF boost +", listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"))
}

@Composable
fun DropdownSelection(label: String, options: List<String>) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label)

        var text by remember { mutableStateOf(options[0]) } // initial value
        var isOpen by remember { mutableStateOf(false) } // initial value

        Column {
            Button(
                onClick = { isOpen = true },
                content = { Text(text) },
                elevation = ButtonDefaults.elevation(0.dp, 0.dp),
                modifier = Modifier
                    .width(50.dp)
                    .height(37.dp)
            )

            DropdownMenu(
                expanded = isOpen,
                onDismissRequest = { isOpen = false },
                modifier = Modifier.width(50.dp)
            ) {
                options.forEach { option ->
                    DropdownMenuItem(onClick = {
                        text = option
                        isOpen = false
                    }) {
                        Text(option)
                    }
                }
            }
        }
    }
}


@Composable
fun HeroStats(text: String) {
    val hero = getHeroInfo(text)
    if (hero != null) {
        val hp = hero["HP"] as? Int ?: 0
        val atk = hero["ATK"] as? Int ?: 0
        val spd = hero["SPD"] as? Int ?: 0
        val def = hero["DEF"] as? Int ?: 0
        val res = hero["RES"] as? Int ?: 0

        Column {
            StatRow("HP", hp)
            StatRow("ATK", atk)
            StatRow("SPD", spd)
            StatRow("DEF", def)
            StatRow("RES", res)
        }
    } else {
        Column {
            StatRow("HP", 0)
            StatRow("ATK", 0)
            StatRow("SPD", 0)
            StatRow("DEF", 0)
            StatRow("RES", 0)
        }
    }
}

@Composable
fun StatRow(statName: String, statValue: Int) {
    Row(
        modifier = Modifier
            .height(30.dp)
            .padding(vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
            // Aquí irá la lógica para restar el valor
        }) {
            Icon(
                painter = painterResource(R.drawable.ic_remove_24dp),
                contentDescription = "Remove",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(20.dp)
            )
        }
        Text(statName)
        Text(text = statValue.toString(), modifier = Modifier.padding(start = 10.dp, end = 2.dp))
        IconButton(onClick = {
            // Aquí irá la lógica para sumar el valor
        }) {
            Icon(
                painter = painterResource(R.drawable.ic_add_24dp),
                contentDescription = "Add",
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(20.dp)
            )
        }
    }
}

@Composable
private fun BottomButtons(navController: NavController){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(47.dp)
            .padding(start = 6.dp, end = 6.dp)
        ,
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier.padding(5.dp),
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
 * Ya esta la imagen mas o menos posicionada, nomas seria cuando ya este la base de datos, mandar la
 * url de la imagen al metodo
 */
@Composable
private fun HeroImage(hero: Map<String, Any>?, context: Context){
    Column(
    ) {

        val imgHero = hero?.get("FULL_IMG") as? String ?: ""

        Image(
            painter = painterResource(getResourceIdByName(imgHero, "drawable", context)),
            contentDescription = "Fondo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(760.dp)
        )
    }
}


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

@Preview(showSystemUi = true )
@Composable
fun BuildScreenPreview(parameters: BuildScreenPreviewParameters = BuildScreenPreviewParameters(rememberNavController(), LocalContext.current)) {
    BuildScreen(parameters.navController, parameters.context)
}