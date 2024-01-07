package com.example.pokedex2.ui.views.list

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.pokedex2.R
import com.example.pokedex2.model.api.response.PokedexResponse
import com.example.pokedex2.model.api.response.ResponsedUrlData
import com.example.pokedex2.model.data.convert.Type
import com.example.pokedex2.ui.WaitCircle
import com.example.pokedex2.ui.capitalized
import com.example.pokedex2.ui.getTypeColor
import com.example.pokedex2.ui.nav.BackFab
import com.example.pokedex2.viewModel.PokedexViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TablaDeTipos(vm: PokedexViewModel, navController: NavHostController) {
    LaunchedEffect(Unit) {
        vm.getTypeList()
    }

    val dataList by vm.typeList.observeAsState(initial = PokedexResponse())
    val typeList = dataList.results
    var selectedType by rememberSaveable { mutableStateOf("") }

    if (typeList.isEmpty()) {
        WaitCircle("mainMenu",navController)
    } else {
        Scaffold(
            floatingActionButton = { BackFab(navController, route = "mainMenu") },
            content = {
                Column {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.type_table),
                            contentDescription = "",
                            modifier = Modifier.size(400.dp)
                        )
                    }

                    LazyVerticalStaggeredGrid(
                        columns = StaggeredGridCells.Fixed(3),
                        content = {
                            items(typeList) { type ->
                                val color = getTypeColor(type)

                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp),
                                    shape = RoundedCornerShape(16.dp),
                                    colors = CardDefaults.cardColors(containerColor = color),
                                ) {
                                    if (!typeExists(type)) {
                                        Box (
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(16.dp)
                                                .clickable {
                                                    selectedType = type.name
                                                },
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(text = capitalized(type.name))
                                        }
                                    } else Text(text = "", modifier = Modifier.padding(32.dp))
                                }
                            }
                        }
                    )

                    if (selectedType.isNotEmpty()) {
                        vm.getType(selectedType)
                        val t by vm.selectedType.observeAsState(initial = Type())

                        TypeRelationsDialog(
                            onDismissRequest = { selectedType = "" },
                            type = t)
                    }
                }
            }
        )
    }
}

@Composable
private fun TypeRelationsDialog(
    onDismissRequest: () -> Unit,
    type: Type,
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box {
                    LazyColumn(
                        content = {
                            item {
                                Column(modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp)) {
                                    Text(text = "Offensive Properties:", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                                    if(type.strongTo.isNotEmpty()) {
                                        Text(text = "--- Super effective (x2) ---")
                                        type.strongTo.forEach {
                                            Text(text = it)
                                        }
                                    }
                                    if(type.weakTo.isNotEmpty()) {
                                        Text(text = "--- Not very effective (×½) ---")
                                        type.weakTo.forEach {
                                            Text(text = it)
                                        }
                                    }
                                    if (type.inmunityTo.isNotEmpty()) {
                                        Text(text = "--- No effect (×0) ---")
                                        type.inmunityTo.forEach {
                                            Text(text = it)
                                        }
                                    }

                                    Text(text = "Defensive Properties:", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                                    if(type.strongFrom.isNotEmpty()) {
                                        Text(text = "--- Super effective (x2) ---")
                                        type.strongFrom.forEach {
                                            Text(text = it)
                                        }
                                    }
                                    if (type.weakFrom.isNotEmpty()) {
                                        Text(text = "--- Not very effective (×½) ---")
                                        type.weakFrom.forEach {
                                            Text(text = it)
                                        }
                                    }
                                    if (type.inmunityFrom.isNotEmpty()) {
                                        Text(text = "--- No effect (×0) ---")
                                        type.inmunityFrom.forEach {
                                            Text(text = it)
                                        }
                                    }
                                }
                            }
                        }
                    )

                    Box (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        IconButton(
                            onClick = {
                                onDismissRequest()
                            },
                            modifier = Modifier.size(32.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null,
                                tint = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}

fun typeExists(type: ResponsedUrlData): Boolean { return type.name == "unknown" || type.name == "shadow" }