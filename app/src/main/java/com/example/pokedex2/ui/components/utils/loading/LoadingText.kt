package com.example.pokedex2.ui.components.utils.loading

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.buildAnnotatedString
import kotlinx.coroutines.delay

private const val CHARGE_VALUE = "."
private const val MAX_VALUE = 3
private const val VALUE_GROUP = 1

@Composable
fun LoadingText(message: String) {
    var valueCount by rememberSaveable { mutableIntStateOf(1) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(500)
            valueCount = (valueCount % MAX_VALUE) + VALUE_GROUP
        }
    }

    val loadingText = buildAnnotatedString {
        append(message)

        repeat(valueCount) {
            append(CHARGE_VALUE)
        }
    }

    Text(text = loadingText)
}