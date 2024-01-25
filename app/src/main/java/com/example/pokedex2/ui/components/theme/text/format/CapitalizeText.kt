package com.example.pokedex2.ui.components.theme.text.format

import java.util.Locale

fun capitalized(text:String):String {
    return text.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
}