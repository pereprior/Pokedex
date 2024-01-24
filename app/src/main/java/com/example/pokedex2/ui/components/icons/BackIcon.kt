package com.example.pokedex2.ui.components.icons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun BackIcon(navController: NavHostController, route: String) {
    IconButton(
        onClick = { navController.navigate(route) }
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back Icon",
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}