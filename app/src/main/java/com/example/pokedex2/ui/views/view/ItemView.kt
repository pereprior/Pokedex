package com.example.pokedex2.ui.views.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.pokedex2.model.data.convert.Item
import com.example.pokedex2.ui.WaitCircle
import com.example.pokedex2.ui.nav.BackFab
import com.example.pokedex2.viewModel.PokedexViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ItemView(vm: PokedexViewModel, navController: NavHostController, selectedItem: String?) {
    LaunchedEffect(Unit) {
        vm.getItem(selectedItem!!)
    }

    val i by vm.selectedItem.observeAsState(initial = Item())
    var rotationState by rememberSaveable { mutableFloatStateOf(0f) }
    val rotationRange = 0f..300f
    var zoomState by rememberSaveable { mutableFloatStateOf(1f) }
    val zoomRange = 0f..5f
    var hideState by rememberSaveable { mutableFloatStateOf(1f) }
    val hideRange = 0f..1f
    var blurState by rememberSaveable { mutableFloatStateOf(0f) }
    val blurRange = 0f..10f

    if (i.name.isEmpty()) {
        WaitCircle("Items", navController)
    } else {
        Scaffold (
            floatingActionButton = { BackFab(navController,"Items") },
            content = {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.secondary)
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    content = {
                        item {
                            AsyncImage(
                                model = i.image,
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(16.dp)
                                    .size(100.dp)
                                    .graphicsLayer {
                                        this.rotationY = rotationState
                                        this.scaleX = zoomState
                                        this.scaleY = zoomState
                                        this.alpha = hideState
                                    }
                                    .blur(
                                        radiusX = blurState.dp,
                                        radiusY = blurState.dp,
                                        edgeTreatment = BlurredEdgeTreatment.Unbounded
                                    ),
                                contentScale = ContentScale.Crop
                            )
                        }

                        item {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Rotation",
                                    style = TextStyle(color = MaterialTheme.colorScheme.onPrimary)
                                )

                                Slider(
                                    value = rotationState,
                                    valueRange = rotationRange,
                                    onValueChange = { rotationState = it },
                                    modifier = Modifier
                                        .width(250.dp)
                                        .padding(horizontal = 20.dp)
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Zoom Effect",
                                    color = MaterialTheme.colorScheme.onSecondary
                                )

                                Slider(
                                    value = zoomState,
                                    valueRange = zoomRange,
                                    onValueChange = { zoomState = it },
                                    modifier = Modifier
                                        .width(250.dp)
                                        .padding(horizontal = 20.dp)
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Alfa Effect",
                                    style = TextStyle(color = MaterialTheme.colorScheme.onPrimary)
                                )

                                Slider(
                                    value = hideState,
                                    valueRange = hideRange,
                                    onValueChange = { hideState = it },
                                    modifier = Modifier
                                        .width(250.dp)
                                        .padding(horizontal = 20.dp)
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Blur Effect",
                                    style = TextStyle(color = MaterialTheme.colorScheme.onPrimary)
                                )

                                Slider(
                                    value = blurState,
                                    valueRange = blurRange,
                                    onValueChange = { blurState = it },
                                    modifier = Modifier
                                        .width(250.dp)
                                        .padding(horizontal = 20.dp)
                                )
                            }
                        }

                        item {
                            Spacer(modifier = Modifier.padding(8.dp))

                            Row {
                                MyLabel(i.name)
                                Spacer(modifier = Modifier.padding(24.dp))
                                MyLabel(i.category)
                            }

                            Spacer(modifier = Modifier.padding(16.dp))
                            MyLabel(i.description)
                            Spacer(modifier = Modifier.padding(16.dp))
                            MyLabel(i.effect)
                            Spacer(modifier = Modifier.padding(16.dp))
                        }
                    }
                )
            }
        )
    }
}

@Composable
private fun MyLabel(text:String) {
    Box (
        modifier = Modifier.clip(RoundedCornerShape(16.dp)).background(MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(16.dp)
        )
    }
}