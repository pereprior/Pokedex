package com.example.pokedex2.ui.components.utils.loading

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex2.R
import com.example.pokedex2.constants.messages.LOADING_DESCRIPTION
import com.example.pokedex2.constants.messages.LOADING_TITLE
import com.example.pokedex2.constants.values.MEDIUM_PADDING_VALUE

@Composable
fun WaitScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Icono de la pantalla de carga
        LoadingImage(R.drawable.pokeball_icon)
        Spacer(modifier = Modifier.padding(MEDIUM_PADDING_VALUE.dp))

        // Texto de la pantalla de carga
        LoadingText(LOADING_TITLE)
        Text(text = LOADING_DESCRIPTION)
    }
}