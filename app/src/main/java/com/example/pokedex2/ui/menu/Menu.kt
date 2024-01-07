package com.example.pokedex2.ui.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pokedex2.R
import com.example.pokedex2.ui.nav.search.DataButton

@Composable
fun MainMenu(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        content = {
            item {
                HelpBell()
            }

            item {
                Image(
                    painter = painterResource(id = R.drawable.pokedex),
                    contentDescription = null,
                    modifier = Modifier.size(125.dp)
                )

                Text(
                    text = "Pokedex",
                    fontSize = 50.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(300.dp)
                        .height(75.dp)
                )
            }

            item {
                Column {
                    DataButton(navController, "Pokedex", route = "PokemonView")

                    DataButton(navController, "Region Maps", route = "Maps")

                    DataButton(navController, "Types Table", route = "TypeTable")

                    DataButton(navController, "Abilities", route = "AbilityView")

                    DataButton(navController, "Moves", route = "MoveView")

                    DataButton(navController, "Items", route = "ItemView")
                }
            }
        }
    )
}
