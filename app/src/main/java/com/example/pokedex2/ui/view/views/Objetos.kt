package com.example.pokedex2.ui.view.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pokedex2.viewModel.PokemonViewModel

@Composable
fun Objetos(viewModel: PokemonViewModel, navController: NavController?) {
    /*val outline = FontFamily(
        Font(R.font.outline, FontWeight.Light),
        Font(R.font.outline, FontWeight.Normal),
        Font(R.font.outline, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.outline, FontWeight.Medium),
        Font(R.font.outline, FontWeight.Bold)
    )*/
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*Image(
            painter = painterResource(id = R.drawable.objetospokemon),
            contentDescription = null,
            modifier = Modifier
                .size(125.dp)
            //.padding(1.dp)
        )

        Text(
            text = "Items",
            fontSize = 50.sp,
            fontFamily = outline,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(300.dp)
                .height(75.dp)
        )*/

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {navController?.navigate("Medicina") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Medicina",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController?.navigate("Poké-Balls") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Poké-Balls",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController?.navigate("Mt's/MO's") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Mt's/MO's",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController?.navigate("Bayas") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Bayas",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController?.navigate("Cartas") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Cartas",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController?.navigate("Obj. Batalla") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Obj. Batalla",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {navController?.navigate("Obj. Clave") },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "Obj. Clave",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }


    }
}
