package com.example.pokedex2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedex2.ui.theme.Pokedex2Theme
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
import com.example.pokedex2.ui.view.views.PokemonView
import com.example.pokedex2.viewModel.PokemonViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pokedex2Theme {
                val navController = rememberNavController()
                val viewModel by viewModels<PokemonViewModel>()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "mainMenu") {
                        composable("Pokedex"){ Pokedex(viewModel,navController) }
                        composable("Maps"){ Mapas(viewModel) }
                        composable("TypeTable"){ TablaDeTipos(viewModel) }
                        composable("Skills") { Habilidades(viewModel) }
                        composable("Movements") { Movimientos(viewModel) }
                        composable("Items") { Objetos(navController) }
                        composable("Favorites") { Favoritos(viewModel) }
                        composable("mainMenu") { MainMenu(navController) }
                        composable("Medicina") { Medicina(viewModel) }
                        composable("Poké-Balls") { PokeBalls(viewModel) }
                        composable("Mt's/MO's") { Discs(viewModel) }
                        composable("Berries") { Berries(viewModel) }
                        composable("Cards") { Cards(viewModel) }
                        composable("Battle Item") { BattleItem(viewModel) }
                        composable("Key Item") { KeyItem(viewModel) }
                        composable(
                            route = "PokemonView/{selectedPokemon}",
                            arguments = listOf(navArgument("selectedPokemon") { type = NavType.StringType })
                        ) { backStackEntry ->
                            val selectedPokemon = backStackEntry.arguments?.getString("selectedPokemon")
                            PokemonView(viewModel,selectedPokemon,navController)
                        }
                    }
                }
            }
        }
    }
}