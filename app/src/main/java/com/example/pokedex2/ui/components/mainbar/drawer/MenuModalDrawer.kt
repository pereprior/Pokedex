package com.example.pokedex2.ui.components.mainbar.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex2.R
import com.example.pokedex2.constants.POKEMON_NAVIGATION_PATH
import com.example.pokedex2.constants.values.HIGH_PADDING_VALUE
import com.example.pokedex2.constants.values.IMAGES_SIZE

@Composable
fun MenuModalDrawer(
    navController: NavHostController,
    drawerState: DrawerState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = HIGH_PADDING_VALUE.dp)
    ) {
        MenuImage(imageResource = R.drawable.pokedex)

        Spacer(modifier = Modifier.size(HIGH_PADDING_VALUE.dp))

        // Plantilla para cada una de las opciones que salen en el menu
        ModalDrawerSection(
            navController = navController,
            route = POKEMON_NAVIGATION_PATH,
            iconResource = R.drawable.pokeball_icon,
            drawerState = drawerState
        )
    }
}

@Composable
private fun MenuImage(imageResource: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = HIGH_PADDING_VALUE.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "Pokedex Image",
            modifier = Modifier
                .width(IMAGES_SIZE.dp),
            contentScale = ContentScale.Crop,
        )
    }
}