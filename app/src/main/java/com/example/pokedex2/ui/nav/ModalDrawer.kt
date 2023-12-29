package com.example.pokedex2.ui.nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex2.R
import kotlinx.coroutines.launch

@Composable
fun MyModalDrawer(navController: NavHostController, drawerState: DrawerState){
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

        ModalDrawerOption(navController,"Pokedex", R.drawable.pokeball_icon,drawerState)
        ModalDrawerOption(navController,"Maps", R.drawable.pokeball_icon,drawerState)
        ModalDrawerOption(navController,"TypeTable", R.drawable.pokeball_icon,drawerState)
        ModalDrawerOption(navController,"Abilities", R.drawable.pokeball_icon,drawerState)
        ModalDrawerOption(navController,"Moves", R.drawable.pokeball_icon,drawerState)
        ModalDrawerOption(navController,"Items", R.drawable.pokeball_icon,drawerState)
        ModalDrawerOption(navController,"Favorites", R.drawable.pokeball_icon,drawerState)

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