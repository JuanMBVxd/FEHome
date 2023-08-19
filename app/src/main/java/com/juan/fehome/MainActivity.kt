package com.juan.fehome

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.juan.fehome.DataBase.SQLiteHelper
import com.juan.fehome.DataBase.service.HeroStatsService
import com.juan.fehome.navigation.AppNavigation
import com.juan.fehome.navigation.AppScreens
import com.juan.fehome.ui.theme.FEHomeTheme

class MainActivity : ComponentActivity() {
    lateinit var fehomeDBHelper: SQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context: Context = this

        fehomeDBHelper = SQLiteHelper(this)
        CreateDataBase(fehomeDBHelper)

        setContent {
            FEHomeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PantallaPrincipal(context)
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PantallaPrincipal(context: Context){
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    val navigation_item = listOf(
        AppScreens.MainScreen,
        AppScreens.AlliesScreen,
        AppScreens.InfoScreen
    )

    // Obtener la ruta actual
    val currentRoute = currentRoute(navController = navController)

    // Verificar si la ruta actual requiere mostrar el menú inferior
    val shouldShowBottomMenu = navigation_item.any { it.route == currentRoute }

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        // Mostrar o no mostrar el Scaffold según la condición
        if (shouldShowBottomMenu) {
            Scaffold(
                scaffoldState = scaffoldState,
                bottomBar = { NavegacionInferior(navController, navigation_item) }
            ) {
                AppNavigation(navController, context)
            }
        } else {
            AppNavigation(navController, context)
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String?{
    val entrada by navController.currentBackStackEntryAsState()
    return entrada?.destination?.route
}

@Composable
fun NavegacionInferior(
    navController: NavHostController,
    menu_items: List<AppScreens>
){
    BottomAppBar(
        // Modificar la altura del menu inferior
        modifier = Modifier.height(60.dp)
    ) {
        BottomNavigation{
            val currentRoute = currentRoute(navController = navController)
            menu_items.forEach { item->
                BottomNavigationItem(
                    selected = currentRoute == item.route,
                    onClick = { navController.navigate(item.route) },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title)
                    },
                    label = {Text(item.title)},
                    alwaysShowLabel = false,
                    selectedContentColor = MaterialTheme.colors.onPrimary,
                    unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled)
                )
            }
        }
    }
}

fun CreateDataBase(fehomeDBHelper: SQLiteHelper){
    HeroStatsService(fehomeDBHelper)
}

/**
 * @Preview(showBackground = true)
@Composable
fun PantallaPrincipalPreview(){
val context = LocalContext.current
PantallaPrincipal(context)
}*/
