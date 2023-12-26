package com.example.pokedex2.ui.view.views.pokemon

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.example.pokedex2.model.api.response.pokemon.Ability
import com.example.pokedex2.model.api.response.pokemon.Stat
import com.example.pokedex2.model.data.convert.Pokemon
import com.example.pokedex2.model.api.response.pokemon.Type
import com.example.pokedex2.ui.theme.*
import com.example.pokedex2.ui.view.utils.BackFab
import com.example.pokedex2.viewModel.PokemonViewModel
import kotlinx.coroutines.delay
import java.util.Locale

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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

    if (p.name.isEmpty()) {
        var errorMessage by rememberSaveable { mutableStateOf("") }
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = errorMessage,
                color = Color.Red,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            CircularProgressIndicator()
        }

        LaunchedEffect(p.name) {
            delay(10000)

            if (p.name.isEmpty()) {
                errorMessage = "404 ERROR: POKEMON NOT FOUND"
                delay(3000)
                navController.navigate("Pokedex")
            }
        }
    } else {
        Scaffold (
            floatingActionButton = { BackFab(navController,"Pokedex") },
            content = {
                LazyColumn(
                    modifier = Modifier.background(MaterialTheme.colorScheme.secondary),
                    content = {
                        item {
                            PokemonImage(p)
                            Spacer(modifier = Modifier.padding(4.dp))
                            PokemonName(p.name)
                            PokemonType(p.types)
                            PokemonAbilities(p.abilities)
                            PokemonStats(p.stats)
                            PokemonSize(p)
                        }
                    }
                )
            }
        )
    }
}

@Composable
private fun PokemonImage(p: Pokemon) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(RoundedCornerShape(bottomStart = 54.dp, bottomEnd = 54.dp))
            .background(color = PrimaryPokedexColor),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.TopStart
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.FavoriteBorder,
                    contentDescription = "",
                    modifier = Modifier.size(32.dp),
                    tint = Color.White
                )
            }
        }
        MyDexNumber(p)

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
private fun MyDexNumber(p: Pokemon) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Text(
            text = "#${String.format("%04d", p.dexNumber)}",
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 28.sp,
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
            fontSize = 40.sp,
            color = MaterialTheme.colorScheme.onSecondary,
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
    val color = getTypeColor(type!!)

    Box(
        modifier = Modifier
            .width(150.dp)
            .height(30.dp)
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(text = type.type.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() })
    }
}

@Composable
fun PokemonAbilities(abilities: List<Ability>) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val normalAbilities = abilities.filter { !it.is_hidden }
        val hiddenAbilities = abilities.filter { it.is_hidden }

        Text(text = "Normal Abilities", modifier = Modifier.padding(8.dp), color = MyGrey)
        Row {
            normalAbilities.forEach { ability ->
                MyAbilityLabel(ability)
            }
        }

        if (hiddenAbilities.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Hidden Abilities", modifier = Modifier.padding(8.dp), color = MyGrey)
            hiddenAbilities.forEach { hiddenAbility ->
                MyAbilityLabel(hiddenAbility)
            }
        }
    }
}

@Composable
private fun MyAbilityLabel(ability: Ability?) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(30.dp)
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(PrimaryPokedexColor),
        contentAlignment = Alignment.Center
    ) {
        Text(text = ability!!.ability.name)
    }
}

@Composable
fun PokemonStats(stats: List<Stat>) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Base Stats", modifier = Modifier.padding(bottom = 8.dp, top = 16.dp), color = MyGrey)
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp)) {
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
                .height(16.dp)
                .width(80.dp)
        ) {
            Text(text = stat.stat.name.uppercase(), color = MaterialTheme.colorScheme.onSecondary)
        }
        Spacer(modifier = Modifier.padding(8.dp))

        Box {
            Canvas(modifier = Modifier
                .width(300.dp)
                .height(36.dp)
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
                        .height(36.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(16.dp))
                ) {
                    drawRect(
                        color = getStatColor(stat.stat.name),
                        topLeft = Offset(0f, 0f),
                    )
                }

                Box(
                    modifier = Modifier
                        .width((stat.base_stat * 1.5).dp)
                        .padding(bottom = 10.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        text = "${stat.base_stat}",
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

private fun getStatColor(statName: String): Color {
    return when (statName) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.Gray
    }
}

private fun getTypeColor(type: Type): Color {
    var color = Color.Transparent
    for (e in TypesColor) {
        if (e.name == type.type.name){
            color = e.color
        }
    }
    return color
}

@Composable
fun PokemonSize(p:Pokemon){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        MySize(p.weight/10, SizeType.KG)
        MySize(p.height/10, SizeType.M)
    }
}

@Composable
private fun MySize(value: Float, size: SizeType) {
    Column(
        modifier = Modifier.padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$value ${size.name}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = size.value,
            color = MyGrey
        )
    }
}

private enum class SizeType(val value: String) {
    KG("Weight"),
    M("Height")
}

@Composable
private fun FavoriteButton() {

}