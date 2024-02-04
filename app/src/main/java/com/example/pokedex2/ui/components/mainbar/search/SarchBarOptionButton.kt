package com.example.pokedex2.ui.components.mainbar.search

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
import com.example.pokedex2.constants.values.MEDIUM_PADDING_VALUE
import com.example.pokedex2.ui.components.utils.text.format.capitalized

@Composable
fun SarchBarOptionButton(
    navController: NavHostController,
    dataName: String,
    route: String
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MEDIUM_PADDING_VALUE.dp)
            .shadow(
                elevation = MEDIUM_PADDING_VALUE.dp,
                ambientColor = Color.Black,
                spotColor = Color.Black
            ),
        onClick = {
            // Accedemos a la pantalla de detalles del objeto seleccionado
            navController.navigate("$route/$dataName")
        }
    ) {
        Text(
            text = capitalized(dataName),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(R.font.pkmndp)),
            modifier = Modifier.fillMaxWidth()
        )
    }
}