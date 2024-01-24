package com.example.pokedex2.ui.components.theme.text.format

import java.util.Locale

fun capitalized(s:String):String {
    return s.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
}