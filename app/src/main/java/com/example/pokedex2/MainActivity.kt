package com.example.pokedex2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedex2.ui.theme.Pokedex2Theme
import com.example.pokedex2.ui.view.utils.ModaDrawer
import com.example.pokedex2.ui.view.menu.MainMenu
import com.example.pokedex2.ui.view.list.Favoritos
import com.example.pokedex2.ui.view.list.Habilidades
import com.example.pokedex2.ui.view.list.Mapas
import com.example.pokedex2.ui.view.list.Movimientos
import com.example.pokedex2.ui.view.list.objects.Objetos
import com.example.pokedex2.ui.view.list.Pokedex
import com.example.pokedex2.ui.view.list.TablaDeTipos
import com.example.pokedex2.ui.view.list.objects.BattleItem
import com.example.pokedex2.ui.view.list.objects.Berries
import com.example.pokedex2.ui.view.list.objects.Cards
import com.example.pokedex2.ui.view.list.objects.Discs
import com.example.pokedex2.ui.view.list.objects.KeyItem
import com.example.pokedex2.ui.view.list.objects.Medicina
import com.example.pokedex2.ui.view.list.objects.PokeBalls
import com.example.pokedex2.ui.view.views.AbilityView
import com.example.pokedex2.ui.view.views.MoveView
import com.example.pokedex2.ui.view.views.pokemon.PokemonView
import com.example.pokedex2.ui.view.views.TypeView
import com.example.pokedex2.viewModel.PokemonViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pokedex2Theme {
                val navController = rememberNavController()
                val viewModel by viewModels<PokemonViewModel>()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet { ModaDrawer(navController,drawerState) }
                    },
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NavHost(navController = navController, startDestination = "mainMenu") {
                            composable("Pokedex"){ Pokedex(viewModel,navController,drawerState) }
                            composable("Maps"){ Mapas(viewModel,drawerState) }
                            composable("TypeTable"){ TablaDeTipos(viewModel,drawerState,navController) }
                            composable("Abilities") { Habilidades(viewModel,drawerState,navController) }
                            composable("Moves") { Movimientos(viewModel,drawerState,navController) }
                            composable("Items") { Objetos(navController,drawerState) }
                            composable("Favorites") { Favoritos(viewModel,drawerState) }
                            composable("mainMenu") { MainMenu(navController,drawerState) }
                            composable("Medicina") { Medicina(viewModel,drawerState) }
                            composable("Poké-Balls") { PokeBalls(viewModel,drawerState) }
                            composable("Mt's/MO's") { Discs(viewModel,drawerState) }
                            composable("Berries") { Berries(viewModel,drawerState) }
                            composable("Cards") { Cards(viewModel,drawerState) }
                            composable("Battle Item") { BattleItem(viewModel,drawerState) }
                            composable("Key Item") { KeyItem(viewModel,drawerState) }
                            composable(
                                route = "PokemonView/{selectedPokemon}",
                                arguments = listOf(navArgument("selectedPokemon") { type = NavType.StringType })
                            ) { backStackEntry ->
                                val selectedPokemon = backStackEntry.arguments?.getString("selectedPokemon")
                                PokemonView(viewModel,selectedPokemon,navController)
                            }
                            composable(
                                route = "TypeView/{selectedType}",
                                arguments = listOf(navArgument("selectedType") { type = NavType.StringType })
                            ) { backStackEntry ->
                                val selectedType = backStackEntry.arguments?.getString("selectedType")
                                TypeView(viewModel,selectedType,navController)
                            }
                            composable(
                                route = "AbilityView/{selectedAbility}",
                                arguments = listOf(navArgument("selectedAbility") { type = NavType.StringType })
                            ) { backStackEntry ->
                                val selectedAbility = backStackEntry.arguments?.getString("selectedAbility")
                                AbilityView(viewModel,selectedAbility,navController)
                            }
                            composable(
                                route = "MoveView/{selectedMove}",
                                arguments = listOf(navArgument("selectedMove") { type = NavType.StringType })
                            ) { backStackEntry ->
                                val selectedMove = backStackEntry.arguments?.getString("selectedMove")
                                MoveView(viewModel,selectedMove,navController)
                            }
                        }
                    }
                }
            }
        }
    }
}