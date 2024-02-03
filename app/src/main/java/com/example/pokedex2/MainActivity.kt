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
import com.example.pokedex2.constants.nav.POKEMON_NAVIGATION_KEY
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
                val pokedexViewModel by viewModels<PokedexViewModel>()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

                SetupPokedexNavigation(
                    navController = navController,
                    drawerState = drawerState,
                    viewModel = pokedexViewModel
                )
            }
        }
    }

    @Composable
    private fun SetupPokedexNavigation(
        navController: NavHostController,
        drawerState: DrawerState,
        viewModel: PokedexViewModel
    ) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    MenuModalDrawer(
                        navController = navController,
                        drawerState = drawerState
                    )
                }
            },
        ) {
            PokedexNavigation(
                navController = navController,
                drawerState = drawerState,
                viewModel = viewModel
            )
        }
    }

    @Composable
    private fun PokedexNavigation(
        navController: NavHostController,
        drawerState: DrawerState,
        viewModel: PokedexViewModel,
    ) {
        NavHost(
            navController = navController,
            startDestination = POKEMON_NAVIGATION_PATH
        ) {
            composable(POKEMON_NAVIGATION_PATH) {
                PokemonListScreen(viewModel, navController, drawerState)
            }

            composable(
                route = "$POKEMON_NAVIGATION_PATH/{$POKEMON_NAVIGATION_KEY}",
                arguments = listOf(
                    navArgument(POKEMON_NAVIGATION_KEY) {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                val selectedPokemon = backStackEntry.arguments?.getString(POKEMON_NAVIGATION_KEY)
                PokemonDetailScreen(
                    viewModel = viewModel,
                    selectedPokemon = selectedPokemon,
                    navController = navController
                )
            }
        }
    }
}