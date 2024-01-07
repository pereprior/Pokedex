package com.example.pokedex2.ui.views.view

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex2.model.data.convert.Ability
import com.example.pokedex2.ui.WaitCircle
import com.example.pokedex2.ui.nav.BackFab
import com.example.pokedex2.viewModel.PokedexViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AbilityView(
    vm: PokedexViewModel,
    selectedAbility: String?,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        vm.getAbility(selectedAbility!!)
    }

    val a by vm.selectedAbility.observeAsState(initial = Ability())

    if (a.name.isEmpty()) {
        WaitCircle()
    } else {
        Scaffold(
            floatingActionButton = { BackFab(navController, "Abilities") },
            content = {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    item {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("Description: ")
                                }
                                append(a.description)
                            },
                            modifier = Modifier.padding(bottom = 8.dp) // Añade espacio en la parte inferior del texto
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    item {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("Learned by: ")
                                }
                            }
                        )
                        for (pokemonName in a.owners) {
                            Text(text = "- ${pokemonName.capitalize()}")
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    item {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("Effect: ")
                                }
                                append(a.effect)
                            }
                        )
                    }
                }
            }
        )
    }
}