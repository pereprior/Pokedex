package com.example.pokedex2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedex2.ui.menu.MainMenu
import com.example.pokedex2.ui.theme.Pokedex2Theme
import com.example.pokedex2.ui.nav.MyModalDrawer
import com.example.pokedex2.ui.views.list.Favoritos
import com.example.pokedex2.ui.views.list.Habilidades
import com.example.pokedex2.ui.views.list.Mapas
import com.example.pokedex2.ui.views.list.Movimientos
import com.example.pokedex2.ui.views.list.Pokedex
import com.example.pokedex2.ui.views.list.TablaDeTipos
import com.example.pokedex2.ui.views.list.Objetos
import com.example.pokedex2.ui.views.view.AbilityView
import com.example.pokedex2.ui.views.view.ItemView
import com.example.pokedex2.ui.views.view.MoveView
import com.example.pokedex2.ui.views.view.PokemonView
import com.example.pokedex2.viewModel.PokedexViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pokedex2Theme {
                val navController = rememberNavController()
                val viewModel by viewModels<PokedexViewModel>()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet { MyModalDrawer(navController,drawerState) }
                    },
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NavigationController(navController, viewModel, drawerState)
                    }
                }
            }
        }
    }

    @Composable
    private fun NavigationController(
        navController: NavHostController,
        viewModel: PokedexViewModel,
        drawerState: DrawerState
    ) {
        NavHost(navController = navController, startDestination = "mainMenu") {
            composable("Pokedex") { Pokedex(viewModel, navController, drawerState) }
            composable("Maps") { Mapas(navController) }
            composable("TypeTable") { TablaDeTipos(viewModel, navController) }
            composable("Abilities") { Habilidades(viewModel, drawerState, navController) }
            composable("Moves") { Movimientos(viewModel, drawerState, navController) }
            composable("Items") { Objetos(viewModel, navController, drawerState) }
            composable("Favorites") { Favoritos(viewModel, drawerState) }
            composable("mainMenu") { MainMenu(navController) }
            composable(
                route = "PokemonView/{selectedPokemon}",
                arguments = listOf(navArgument("selectedPokemon") { type = NavType.StringType })
            ) { backStackEntry ->
                val selectedPokemon = backStackEntry.arguments?.getString("selectedPokemon")
                PokemonView(viewModel, selectedPokemon, navController)
            }
            composable(
                route = "AbilityView/{selectedAbility}",
                arguments = listOf(navArgument("selectedAbility") { type = NavType.StringType })
            ) { backStackEntry ->
                val selectedAbility = backStackEntry.arguments?.getString("selectedAbility")
                AbilityView(viewModel, selectedAbility, navController)
            }
            composable(
                route = "MoveView/{selectedMove}",
                arguments = listOf(navArgument("selectedMove") { type = NavType.StringType })
            ) { backStackEntry ->
                val selectedMove = backStackEntry.arguments?.getString("selectedMove")
                MoveView(viewModel, selectedMove, navController)
            }
            composable(
                route = "ItemView/{selectedItem}",
                arguments = listOf(navArgument("selectedItem") { type = NavType.StringType })
            ) { backStackEntry ->
                val selectedItem = backStackEntry.arguments?.getString("selectedItem")
                ItemView(viewModel, navController, selectedItem)
            }
        }
    }
}