package com.example.pokedex2.ui.components.theme

import androidx.compose.ui.graphics.Color
import com.example.pokedex2.model.api.response.ResponsedUrlData

// Default
val PrimaryPokedexColor = Color(0xFFC92133)
val DarkGrey = Color(0xFF2b292c)
val LightGrey = Color(0xff6d6a6d)

// Bar Color
val HPColor = Color(0xFFF5FF00)
val AtkColor = Color(1f, 0f, 0f, 0.66f)
val DefColor = Color(0f, 0f, 1f, 0.44f)
val SpAtkColor = Color(0.671f, 0f, 1f, 0.57f)
val SpDefColor = Color(1f, 0f, 0.8f, 0.7f)
val SpdColor = Color(0f, 1f, 0.063f, 0.55f)

// Types
fun getTypeColor(type: ResponsedUrlData): Color {
    var color = Color.Transparent
    for (e in TypesColorList) {
        if (e.key == type.name){
            color = e.value
        }
    }
    return color
}

val TypesColorList = mapOf(
    Pair("normal", Color(0xFFA8A77A)),
    Pair("fire", Color(0xFFEE8130)),
    Pair("water", Color(0xFF6390F0)),
    Pair("electric", Color(0xFFF7D02C)),
    Pair("grass", Color(0xFF7AC74C)),
    Pair("ice", Color(0xFF96D9D6)),
    Pair("fighting", Color(0xFFC22E28)),
    Pair("poison", Color(0xFFA33EA1)),
    Pair("ground", Color(0xFFE2BF65)),
    Pair("flying", Color(0xFFA98FF3)),
    Pair("psychic", Color(0xFFF95587)),
    Pair("bug", Color(0xFFA6B91A)),
    Pair("rock", Color(0xFFB6A136)),
    Pair("ghost", Color(0xFF735797)),
    Pair("dragon", Color(0xFF6F35FC)),
    Pair("dark", Color(0xFF705746)),
    Pair("steel", Color(0xFFB7B7CE)),
    Pair("fairy", Color(0xFFD685AD))
)