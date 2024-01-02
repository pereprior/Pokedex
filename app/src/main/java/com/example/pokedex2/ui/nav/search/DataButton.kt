package com.example.pokedex2.ui.nav.search

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pokedex2.model.data.convert.Pokemon
import com.example.pokedex2.ui.capitalized
import com.example.pokedex2.viewModel.PokedexViewModel

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
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}