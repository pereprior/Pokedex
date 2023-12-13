package com.example.pokedex2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedex2.ui.theme.Pokedex2Theme
import com.example.pokedex2.ui.view.menu.MainMenu
import com.example.pokedex2.ui.view.views.Favoritos
import com.example.pokedex2.ui.view.views.Habilidades
import com.example.pokedex2.ui.view.views.Mapas
import com.example.pokedex2.ui.view.views.Movimientos
import com.example.pokedex2.ui.view.views.Objetos
import com.example.pokedex2.ui.view.views.Pokedex
import com.example.pokedex2.ui.view.views.TablaDeTipos
import com.example.pokedex2.viewModel.PokemonViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pokedex2Theme {
                val viewModel by viewModels<PokemonViewModel>()
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "mainMenu"){
                        composable("Pokedex"){
                            Pokedex(viewModel)
                        }
                        composable("Mapas"){
                            Mapas(viewModel)
                        }
                        composable("Tabla de Tipos"){
                            TablaDeTipos(viewModel)
                        }
                        composable("Habilidades") {
                            Habilidades(viewModel)
                        }
                        composable("Movimientos") {
                            Movimientos(viewModel)
                        }
                        composable("Objetos") {
                            Objetos(viewModel, navController)
                        }
                        composable("Favoritos") {
                            Favoritos(viewModel)
                        }
                        composable("mainMenu") {
                            MainMenu(navController)
                        }
                    }
                }
            }
        }
    }
}