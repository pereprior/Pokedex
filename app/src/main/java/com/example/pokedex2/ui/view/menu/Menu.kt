package com.example.pokedex2.ui.view.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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

@Composable
fun MainMenu(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.pokedex),
            contentDescription = null,
            modifier = Modifier
                .size(125.dp)
            //.padding(1.dp)
        )

        Text(
            text = "Pokedex",
            fontSize = 50.sp,
            //fontFamily = pokemonhollow,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(300.dp)
                .height(75.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {navController.navigate("Pokedex") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Pokedex",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController.navigate("Maps") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Region Maps",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController.navigate("TypeTable") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Types Table",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController.navigate("Abilities") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Abilities",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController.navigate("Moves") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Moves",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController.navigate("Items") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Items",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController.navigate("Favorites") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Favorites",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }
    }
}

