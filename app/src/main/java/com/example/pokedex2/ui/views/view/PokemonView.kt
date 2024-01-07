package com.example.pokedex2.ui.views.view

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.pokedex2.model.api.response.pokemon.Ability
import com.example.pokedex2.model.api.response.pokemon.Stat
import com.example.pokedex2.model.data.convert.Pokemon
import com.example.pokedex2.model.api.response.pokemon.Type
import com.example.pokedex2.ui.WaitCircle
import com.example.pokedex2.ui.capitalized
import com.example.pokedex2.ui.getTypeColor
import com.example.pokedex2.ui.theme.*
import com.example.pokedex2.ui.nav.BackFab
import com.example.pokedex2.viewModel.PokedexViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PokemonView(
    vm: PokedexViewModel,
    selectedPokemon: String?,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        vm.getPokemon(selectedPokemon!!)
    }

    val p by vm.selectedPokemon.observeAsState(initial = Pokemon())

    if (p.name.isEmpty()) {
        WaitCircle("PokemonView/Pokedex", navController)
    } else {
        var offset by remember { mutableFloatStateOf(0f) }

        LaunchedEffect(Unit) {
            animate(
                initialValue = -1000f,
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = 800,
                    easing = LinearEasing
                )
            ) { value, _ ->
                offset = value
            }
        }

        Scaffold (
            modifier = Modifier.offset(offset.dp),
            floatingActionButton = { BackFab(navController,"PokemonView/Pokedex") },
            content = {
                LazyColumn(
                    modifier = Modifier.background(MaterialTheme.colorScheme.secondary),
                    content = {
                        item {
                            PokemonImage(p,vm)
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
private fun PokemonImage(p: Pokemon, vm: PokedexViewModel) {
    var isFav by rememberSaveable { mutableStateOf(false) }
    var isOpenDialog by rememberSaveable { mutableStateOf(false) }

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
            IconButton(
                onClick = {
                    vm.setFavorite(p)
                    isFav = !isFav
                }
            ) {
                Icon(
                    imageVector = if (isFav) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
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
                    isOpenDialog = true
                }
        )

        if (isOpenDialog) {
            FormsDialog(
                onDismissRequest = { isOpenDialog = false },
                images = p.forms
            )
        }
    }
}

@Composable
private fun FormsDialog(
    onDismissRequest: () -> Unit,
    images: List<Any>,
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box {
                    LazyColumn(
                        content = {
                            item {
                                images.forEach { imageUrl ->
                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (imageUrl is String) {
                                            AsyncImage(
                                                model = imageUrl,
                                                contentDescription = "",
                                                contentScale = ContentScale.Fit,
                                                modifier = Modifier
                                                    .height(160.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    )

                    Box (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        IconButton(
                            onClick = {
                                onDismissRequest()
                            },
                            modifier = Modifier.size(32.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null,
                                tint = Color.Black
                            )
                        }
                    }
                }
            }
        }
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
            text = capitalized(name),
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
    val color = getTypeColor(type?.type!!)

    Box(
        modifier = Modifier
            .width(150.dp)
            .height(30.dp)
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(text = capitalized(type.type.name))
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

        Text(text = "Normal Abilities", modifier = Modifier.padding(8.dp), color = LightGrey)
        Row {
            normalAbilities.forEach { ability ->
                MyAbilityLabel(ability)
            }
        }

        if (hiddenAbilities.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Hidden Abilities", modifier = Modifier.padding(8.dp), color = LightGrey)
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
            .background(MaterialTheme.colorScheme.onSecondary),
        contentAlignment = Alignment.Center
    ) {
        Text(text = capitalized(ability!!.ability.name))
    }
}

@Composable
fun PokemonStats(stats: List<Stat>) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Base Stats", modifier = Modifier.padding(bottom = 8.dp, top = 16.dp), color = LightGrey)
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

        val barSize = when {
            stat.base_stat > 165 -> 165
            stat.base_stat < 20 -> 20
            else -> stat.base_stat
        }

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
                        .width((barSize * 2).dp)
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
                        .width((barSize * 1.5).dp)
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

@Composable
fun PokemonSize(p:Pokemon){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        MySize(p.weight, SizeType.KG)
        MySize(p.height, SizeType.M)
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
            color = LightGrey
        )
    }
}

private enum class SizeType(val value: String) {
    KG("Weight"),
    M("Height")
}