package com.example.pokedex2.ui.nav

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun BackFab(navController: NavHostController, route:String){
    FloatingActionButton(
        onClick = { navController.navigate(route) },
        modifier = Modifier
            .padding(16.dp),
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimary)
    }
}