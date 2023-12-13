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
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex2.R

@Composable
fun MainMenu(navController : NavController?) {
    /*val pokemonhollow = FontFamily(
        Font(R.font.pokemonHollow, FontWeight.Light),
        Font(R.font.pokemonHollow, FontWeight.Normal),
        Font(R.font.pokemonHollow, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.pokemonHollow, FontWeight.Medium),
        Font(R.font.pokemonHollow, FontWeight.Bold)
    )
    val pokemonsolid = FontFamily(
        Font(R.font.pokemonSolid, FontWeight.Light),
        Font(R.font.pokemonSolid, FontWeight.Normal),
        Font(R.font.pokemonSolid, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.pokemonSolid, FontWeight.Medium),
        Font(R.font.pokemonSolid, FontWeight.Bold)
    )*/
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon),
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
            onClick = {navController?.navigate("Pokedex") },
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
            onClick = {navController?.navigate("Mapas") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Mapas",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController?.navigate("Tabla de Tipos") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Tabla de Tipos",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController?.navigate("Habilidades") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Habilidades",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController?.navigate("Movimientos") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Movimientos",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController?.navigate("Objetos") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Objetos",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController?.navigate("Favoritos") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Favoritos",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }
    }
}

