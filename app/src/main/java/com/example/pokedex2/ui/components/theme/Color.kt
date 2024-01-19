package com.example.pokedex2.ui.components.theme

import androidx.compose.ui.graphics.Color

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
data class TypeColor(val name:String,val color:Color)
val TypesColor = listOf(
    TypeColor("normal", Color(0xFFA8A77A)),
    TypeColor("fire", Color(0xFFEE8130)),
    TypeColor("water", Color(0xFF6390F0)),
    TypeColor("electric", Color(0xFFF7D02C)),
    TypeColor("grass", Color(0xFF7AC74C)),
    TypeColor("ice", Color(0xFF96D9D6)),
    TypeColor("fighting", Color(0xFFC22E28)),
    TypeColor("poison", Color(0xFFA33EA1)),
    TypeColor("ground", Color(0xFFE2BF65)),
    TypeColor("flying", Color(0xFFA98FF3)),
    TypeColor("psychic", Color(0xFFF95587)),
    TypeColor("bug", Color(0xFFA6B91A)),
    TypeColor("rock", Color(0xFFB6A136)),
    TypeColor("ghost", Color(0xFF735797)),
    TypeColor("dragon", Color(0xFF6F35FC)),
    TypeColor("dark", Color(0xFF705746)),
    TypeColor("steel", Color(0xFFB7B7CE)),
    TypeColor("fairy", Color(0xFFD685AD))
)