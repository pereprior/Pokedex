package com.example.pokedex2.ui.views.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex2.model.data.convert.Move
import com.example.pokedex2.ui.WaitCircle
import com.example.pokedex2.ui.nav.BackFab
import com.example.pokedex2.viewModel.PokedexViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MoveView (
    vm: PokedexViewModel,
    selectedMove: String?,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        vm.getMove(selectedMove!!)
    }

    val m by vm.selectedMove.observeAsState(initial = Move())

    if (m.name.isEmpty()) {
        WaitCircle()
    } else {
        Scaffold(
            floatingActionButton = { BackFab(navController, "Moves") },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Description: ${m.description}",
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = buildAnnotatedString {
                            append("Category: ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("${m.category}")
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(text = "Learned by:")
                    for (pokemonName in m.learnedBy) {
                        Text(text = "- ${pokemonName.capitalize()}",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        )
    }
}