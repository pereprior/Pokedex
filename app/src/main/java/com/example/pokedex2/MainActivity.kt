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
import com.example.pokedex2.constants.nav.POKEMON_NAVIGATION_PATH
import com.example.pokedex2.ui.components.theme.Pokedex2Theme
import com.example.pokedex2.ui.components.bar.drawer.MenuModalDrawer
import com.example.pokedex2.ui.screens.list.PokemonListScreen
import com.example.pokedex2.ui.screens.detail.pokemon.PokemonDetailScreen
import com.example.pokedex2.ui.viewmodels.PokedexViewModel
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
                        ModalDrawerSheet { MenuModalDrawer(navController,drawerState) }
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
        NavHost(navController = navController, startDestination = POKEMON_NAVIGATION_PATH) {
            composable(POKEMON_NAVIGATION_PATH) { PokemonListScreen(pokedexVM, navController, drawerState) }
            composable(
                route = "$POKEMON_NAVIGATION_PATH/{selectedPokemon}",
                arguments = listOf(navArgument("selectedPokemon") { type = NavType.StringType })
            ) { backStackEntry ->
                val selectedPokemon = backStackEntry.arguments?.getString("selectedPokemon")
                PokemonDetailScreen(pokedexVM, selectedPokemon, navController)
            }
        }
    }
}