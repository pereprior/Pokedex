package com.example.pokedex2.ui.view.utils

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex2.R
import com.example.pokedex2.model.api.response.ResponsedUrlData
import com.example.pokedex2.ui.view.views.pokemon.MySearchBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    drawerState: DrawerState,
    navController: NavHostController,
    pokemonList: List<ResponsedUrlData>
) {
    val scope = rememberCoroutineScope()
    val helpValue by rememberInfiniteTransition(label = "").animateFloat(
        initialValue = 25f,
        targetValue = -25f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 600,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )

    TopAppBar(
        modifier = Modifier.fillMaxWidth().height(100.dp),
        title = { Text(text = "") },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                },
                modifier = Modifier.fillMaxHeight()
            ) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Back", tint = MaterialTheme.colorScheme.onPrimary)
            }
        },
        actions = {
            MySearchBar(navController, pokemonList)

            IconButton(onClick = { /*TODO*/ }) {
                Icon (
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "Help Bell",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .graphicsLayer {
                            transformOrigin = TransformOrigin(
                                pivotFractionX = 0.5f,
                                pivotFractionY = 0.0f
                            )
                            rotationZ = helpValue
                        }
                )
            }
        },
    )
}

@Composable
fun ModaDrawer(navController: NavHostController, drawerState: DrawerState){
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.pokedex),
                contentDescription = "Pokedex",
                modifier = Modifier
                    .width(200.dp)
                    .height(164.dp),
                contentScale = ContentScale.Crop,
            )
        }
        Spacer(modifier = Modifier.size(30.dp))

        ModalDrawerOption(navController,"Pokedex",R.drawable.pokeball_icon,drawerState)
        ModalDrawerOption(navController,"Maps",R.drawable.pokeball_icon,drawerState)
        ModalDrawerOption(navController,"TypeTable",R.drawable.pokeball_icon,drawerState)
        ModalDrawerOption(navController,"Abilities",R.drawable.pokeball_icon,drawerState)
        ModalDrawerOption(navController,"Moves",R.drawable.pokeball_icon,drawerState)
        ModalDrawerOption(navController,"Items",R.drawable.pokeball_icon,drawerState)
        ModalDrawerOption(navController,"Favorites",R.drawable.pokeball_icon,drawerState)

    }
}

@Composable
private fun ModalDrawerOption(navController: NavHostController, route:String, image:Int, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .clickable(onClick = {
                navController.navigate(route)
                scope.launch {
                    drawerState.apply {
                        if (isClosed) open() else close()
                    }
                }
            })
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Icon(
            painter = painterResource(id = image),
            contentDescription = "Info",
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .size(24.dp)
        )
        Text(text = route)
    }
}

@Composable
fun BackFab(navController:NavHostController,route:String){
    FloatingActionButton(
        onClick = { navController.navigate(route) },
        modifier = Modifier
            .padding(16.dp),
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimary)
    }
}