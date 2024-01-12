package com.example.pokedex2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedex2.ui.theme.Pokedex2Theme
import com.example.pokedex2.ui.nav.MyModalDrawer
import com.example.pokedex2.ui.views.list.Habilidades
import com.example.pokedex2.ui.views.list.Mapas
import com.example.pokedex2.ui.views.list.Movimientos
import com.example.pokedex2.ui.views.list.Pokedex
import com.example.pokedex2.ui.views.list.TablaDeTipos
import com.example.pokedex2.ui.views.list.Objetos
import com.example.pokedex2.ui.views.view.ability.AbilityView
import com.example.pokedex2.ui.views.view.item.ItemView
import com.example.pokedex2.ui.views.view.move.MoveView
import com.example.pokedex2.ui.views.view.pokemon.PokemonView
import com.example.pokedex2.viewModel.PokedexViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pokedex2Theme {
                val navController = rememberNavController()
                val pokedexVM by viewModels<PokedexViewModel>()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet { MyModalDrawer(navController,drawerState) }
                    },
                ) {
                    NavigationController(navController, drawerState, pokedexVM)
                }
            }
        }
    }

    @Composable
    private fun NavigationController(
        navController: NavHostController,
        drawerState: DrawerState,
        pokedexVM: PokedexViewModel,
    ) {
        NavHost(navController = navController, startDestination = "PokemonView/Pokedex") {
            composable("PokemonView/Pokedex") { Pokedex(pokedexVM, navController, drawerState) }
            composable("Maps/Region Maps") { Mapas(navController) }
            composable("TypeTable/Types Table") { TablaDeTipos(pokedexVM, navController) }
            composable("AbilityView/Abilities") { Habilidades(pokedexVM, drawerState, navController) }
            composable("MoveView/Moves") { Movimientos(pokedexVM, drawerState, navController) }
            composable("ItemView/Items") { Objetos(pokedexVM, navController, drawerState) }
            composable(
                route = "PokemonView/{selectedPokemon}",
                arguments = listOf(navArgument("selectedPokemon") { type = NavType.StringType })
            ) { backStackEntry ->
                val selectedPokemon = backStackEntry.arguments?.getString("selectedPokemon")
                PokemonView(pokedexVM, selectedPokemon, navController)
            }
            composable(
                route = "AbilityView/{selectedAbility}",
                arguments = listOf(navArgument("selectedAbility") { type = NavType.StringType })
            ) { backStackEntry ->
                val selectedAbility = backStackEntry.arguments?.getString("selectedAbility")
                AbilityView(pokedexVM, selectedAbility, navController)
            }
            composable(
                route = "MoveView/{selectedMove}",
                arguments = listOf(navArgument("selectedMove") { type = NavType.StringType })
            ) { backStackEntry ->
                val selectedMove = backStackEntry.arguments?.getString("selectedMove")
                MoveView(pokedexVM, selectedMove, navController)
            }
            composable(
                route = "ItemView/{selectedItem}",
                arguments = listOf(navArgument("selectedItem") { type = NavType.StringType })
            ) { backStackEntry ->
                val selectedItem = backStackEntry.arguments?.getString("selectedItem")
                ItemView(pokedexVM, navController, selectedItem)
            }
        }
    }
}