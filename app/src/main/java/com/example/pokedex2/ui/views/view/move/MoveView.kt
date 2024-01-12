package com.example.pokedex2.ui.views.view.move

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.pokedex2.ui.capitalized
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
        WaitCircle("MoveView/Moves", navController)
    } else {
        Scaffold(
            floatingActionButton = { BackFab(navController, "MoveView/Moves") },
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
                                append(m.description)
                            },
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    item {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("Category: ")
                                }
                                append(capitalized(m.category))
                            }
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    item {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("PP: ")
                                }
                                append("${m.pp}")
                            }
                        )
                    }

                    item {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("Power: ")
                                }
                                append("${m.power}")
                            }
                        )
                    }

                    item {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("Accuracy: ")
                                }
                                append("${m.accuracy}")
                            }
                        )
                    }

                    item {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("Priority: ")
                                }
                                append("${m.priority}")
                            }
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
                        for (pokemonName in m.learnedBy) {
                            Text(text = "- ${capitalized(pokemonName)}")
                        }
                    }
                }
            }
        )
    }
}