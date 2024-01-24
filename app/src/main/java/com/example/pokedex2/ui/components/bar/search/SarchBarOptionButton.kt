package com.example.pokedex2.ui.components.bar.search

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pokedex2.R
import com.example.pokedex2.ui.components.theme.text.format.capitalized

@Composable
fun SarchBarOptionButton(navController: NavHostController, name: String, route: String) {
    Spacer(modifier = Modifier.padding(4.dp))
    Button(
        onClick = {
            navController.navigate("$route/$name")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .shadow(
                elevation = 16.dp,
                ambientColor = Color.Black,
                spotColor = Color.Black
            )
    ) {
        Text(
            text = capitalized(name),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(R.font.pkmndp)),
            modifier = Modifier.fillMaxWidth()
        )
    }
}