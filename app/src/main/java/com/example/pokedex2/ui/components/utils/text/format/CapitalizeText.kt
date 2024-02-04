package com.example.pokedex2.ui.components.utils.text.format

import java.util.Locale

fun capitalized(text:String):String {
    // Devolver el texto con la primera letra en mayuscula y las demas en minuscula
    return text.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
}