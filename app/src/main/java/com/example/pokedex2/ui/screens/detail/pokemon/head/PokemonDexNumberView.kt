package com.example.pokedex2.ui.screens.detail.pokemon.head

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pokedex2.model.data.convert.Pokemon

@Composable
fun PokemonDexNumberView(p: Pokemon, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        BackButton(navController = navController)

        DexNumber(p.dexNumber)
    }
}

@Composable
fun BackButton(navController: NavHostController) {
    IconButton(
        onClick = { navController.navigate("PokemonView/Pokedex") }
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back Icon",
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun DexNumber(dexNumber: Int) {
    Text(
        text = "#${String.format("%04d", dexNumber)}",
        color = MaterialTheme.colorScheme.onPrimary,
        fontSize = 28.sp,
        textAlign = TextAlign.End
    )
}
