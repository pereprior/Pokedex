package com.example.pokedex2.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pokedex2.R

const val LANGUAGE_KEY = "en"

val PokemonFont = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.pkmndp)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 1.sp
    )
)

/*val pokemonhollow = FontFamily(
    Font(R.font.pokemonhollow, FontWeight.Light),
    Font(R.font.pokemonhollow, FontWeight.Normal),
    Font(R.font.pokemonhollow, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.pokemonhollow, FontWeight.Medium),
    Font(R.font.pokemonhollow, FontWeight.Bold)
)

val pokemonsolid = FontFamily(
    Font(R.font.pokemonsolid, FontWeight.Light),
    Font(R.font.pokemonsolid, FontWeight.Normal),
    Font(R.font.pokemonsolid, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.pokemonsolid, FontWeight.Medium),
    Font(R.font.pokemonsolid, FontWeight.Bold)
)*/