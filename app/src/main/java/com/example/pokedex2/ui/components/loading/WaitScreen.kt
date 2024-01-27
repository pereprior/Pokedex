package com.example.pokedex2.ui.components.loading

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex2.R

@Composable
fun WaitScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LoadingImage(R.drawable.pokeball_icon)
        Spacer(modifier = Modifier.padding(8.dp))
        LoadingText("Obtaining data")
        Text(text = "Please, wait few seconds")
    }
}