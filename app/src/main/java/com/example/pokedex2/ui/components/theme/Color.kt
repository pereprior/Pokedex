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

val statColorMapping = mapOf(
    "hp" to HPColor,
    "attack" to AtkColor,
    "defense" to DefColor,
    "special-attack" to SpAtkColor,
    "special-defense" to SpDefColor,
    "speed" to SpdColor
)

fun getStatColor(statName: String): Color {
    return statColorMapping[statName] ?: Color.Gray
}

// Types
val normalColor = Color(0xFFA8A77A)
val fireColor = Color(0xFFEE8130)
val waterColor = Color(0xFF6390F0)
val electricColor = Color(0xFFF7D02C)
val grassColor = Color(0xFF7AC74C)
val iceColor = Color(0xFF96D9D6)
val fightingColor = Color(0xFFC22E28)
val poisonColor = Color(0xFFA33EA1)
val groundColor = Color(0xFFE2BF65)
val flyingColor = Color(0xFFA98FF3)
val psychicColor = Color(0xFFF95587)
val bugColor = Color(0xFFA6B91A)
val rockColor = Color(0xFFB6A136)
val ghostColor = Color(0xFF735797)
val dragonColor = Color(0xFF6F35FC)
val darkColor = Color(0xFF705746)
val steelColor = Color(0xFFB7B7CE)
val fairyColor = Color(0xFFD685AD)

val typesColorMapping = mapOf(
    "normal" to normalColor,
    "fire" to fireColor,
    "water" to waterColor,
    "electric" to electricColor,
    "grass" to grassColor,
    "ice" to iceColor,
    "fighting" to fightingColor,
    "poison" to poisonColor,
    "ground" to groundColor,
    "flying" to flyingColor,
    "psychic" to psychicColor,
    "bug" to bugColor,
    "rock" to rockColor,
    "ghost" to ghostColor,
    "dragon" to dragonColor,
    "dark" to darkColor,
    "steel" to steelColor,
    "fairy" to fairyColor
)

// Usage
fun getTypeColor(type: String): Color {
    return typesColorMapping[type] ?: Color.Gray
}