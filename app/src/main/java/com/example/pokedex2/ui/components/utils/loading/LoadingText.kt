package com.example.pokedex2.ui.components.utils.loading

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.buildAnnotatedString
import com.example.pokedex2.constants.messages.LOADING_VALUE
import com.example.pokedex2.constants.messages.LOADING_MAX_VALUE
import com.example.pokedex2.constants.messages.LOADING_VALUE_GROUP
import kotlinx.coroutines.delay

@Composable
fun LoadingText(message: String) {
    var valueCount by rememberSaveable { mutableIntStateOf(1) }

    // Mientras dure la pantalla de carga, ira apareciendo y despareciendo para dar sensacion de carga
    LaunchedEffect(Unit) {
        while (true) {
            // Frecuencia en la que el texto va cargando
            delay(500)
            valueCount = (valueCount % LOADING_MAX_VALUE) + LOADING_VALUE_GROUP
        }
    }

    val loadingText = buildAnnotatedString {
        // Texto estatico
        append(message)

        // Texto animado
        repeat(valueCount) {
            append(LOADING_VALUE)
        }
    }

    Text(text = loadingText)
}