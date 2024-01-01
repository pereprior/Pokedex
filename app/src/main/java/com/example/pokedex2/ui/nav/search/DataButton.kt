package com.example.pokedex2.ui.nav.search

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pokedex2.ui.capitalized

@Composable
fun DataButton(navController: NavHostController, name: String, route: String) {
    Spacer(modifier = Modifier.padding(4.dp))
    Button(
        onClick = { navController.navigate("$route/$name") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = capitalized(name),
            textAlign = TextAlign.Start,
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}