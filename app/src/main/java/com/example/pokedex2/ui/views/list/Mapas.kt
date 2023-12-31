package com.example.pokedex2.ui.views.list

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import com.example.pokedex2.model.data.maps.MapData
import com.example.pokedex2.model.data.maps.TestDataItem
import com.example.pokedex2.ui.nav.BackFab

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Mapas(navController: NavHostController) {
    val mapsData = MapData.testmapsData.distinct()
    var showDialog by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<TestDataItem?>(null) }

    Scaffold(
        floatingActionButton = { BackFab(navController, route = "mainMenu") },
        content = {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(128.dp),
                contentPadding = PaddingValues(8.dp),
                content = {
                    items(mapsData) { item ->
                        TestDataItemCard(item = item) {
                            selectedItem = item
                            showDialog = true
                        }
                    }
                }
            )
        }
    )

    if (showDialog && selectedItem != null) {
        ImageDialog(item = selectedItem!!, onDismiss = {
            showDialog = false
            selectedItem = null
        })
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestDataItemCard(item: TestDataItem, onImageClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        onClick = onImageClick
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(1.dp)
        ) {
            Image(
                painter = painterResource(id = item.drawable),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height((120..340).random().dp)
                    .clip(shape = MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop // Utiliza ContentScale.Crop en lugar de ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = item.title, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
fun ImageDialog(item: TestDataItem, onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(
            dismissOnClickOutside = true,
            dismissOnBackPress = true
        ),
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
            ) {
                Image(
                    painter = painterResource(id = item.drawable),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop // Utiliza ContentScale.Crop en lugar de ContentScale.FillBounds
                )
            }
        }
    )
}