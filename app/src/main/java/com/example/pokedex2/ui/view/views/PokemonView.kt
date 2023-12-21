package com.example.pokedex2.ui.view.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.pokedex2.model.api.response.pokemon.Stat
import com.example.pokedex2.model.data.convert.Pokemon
import com.example.pokedex2.model.api.response.pokemon.Type
import com.example.pokedex2.ui.theme.PrimaryPokedexColor
import com.example.pokedex2.ui.view.BackFab
import com.example.pokedex2.viewModel.PokemonViewModel
import java.util.Locale

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonView(
    vm: PokemonViewModel,
    selectedPokemon: String?,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        vm.getPokemon(selectedPokemon!!)
    }

    val p by vm.selectedPokemon.observeAsState(initial = Pokemon())

    Scaffold (
        floatingActionButton = { BackFab(navController,"Pokedex") },
        content = {
            Column {
                PokemonImage(p)
                Spacer(modifier = Modifier.padding(4.dp))
                PokemonName(p.name)
                PokemonType(p.types)
                PokemonSize(p)
                PokemonStats(p.stats)
            }
        }
    )
}

@Composable
private fun PokemonImage(p: Pokemon) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .clip(RoundedCornerShape(bottomStart = 54.dp, bottomEnd = 54.dp))
            .background(color = PrimaryPokedexColor),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = p.normalSprite,
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .clickable {
                    /*isShiny = !isShiny
                    isFirstClick = false*/
                }
        )
    }
}

@Composable
private fun PokemonName(name:String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
            fontSize = 40.sp
        )
    }
}

@Composable
fun PokemonType(types: List<Type>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        types.map { type ->
            MyTypeLabel(type)
        }
    }
}

@Composable
private fun MyTypeLabel(type: Type?) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(30.dp)
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(PrimaryPokedexColor),
        contentAlignment = Alignment.Center
    ) {
        Text(text = type!!.type.name)
    }
}

@Composable
fun PokemonSize(p:Pokemon){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        MySize(p.weight/10, SizeType.KG)
        MySize(p.height/10, SizeType.M)
    }
}

@Composable
private fun MySize(value: Float, type: SizeType) {
    Column(
        modifier = Modifier.padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$value ${type.name}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = type.value,
            color = Color(0xff6d6a6d)
        )
    }
}

private enum class SizeType(val value: String) {
    KG("Weight"),
    M("Height")
}

@Composable
fun PokemonStats(stats: List<Stat>) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Base Stats",fontSize = 24.sp)
        Spacer(modifier = Modifier.padding(8.dp))
        Column(modifier = Modifier.fillMaxWidth().padding(start = 24.dp)) {
            stats.map { stat ->
                MyStat(stat)
            }
        }
    }
}

@Composable
private fun MyStat(stat: Stat) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .weight(40f)
                .height(16.dp)
        ) {
            Text(text = stat.stat.name.uppercase())
        }
        Spacer(modifier = Modifier.padding(8.dp))

        Box {
            Canvas(modifier = Modifier
                .width(300.dp)
                .height(30.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(16.dp))
            ) {
                drawRect(
                    color = Color.White,
                    topLeft = Offset(0f, 0f),
                )
            }

            Box(contentAlignment = Alignment.BottomCenter) {
                Canvas(
                    modifier = Modifier
                        .width((stat.base_stat * 2).dp)
                        .height(30.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(16.dp))
                ) {
                    drawRect(
                        color = Color.Black,
                        topLeft = Offset(0f, 0f),
                    )
                }

                Text(
                    text = "${stat.base_stat}",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        }
    }
}