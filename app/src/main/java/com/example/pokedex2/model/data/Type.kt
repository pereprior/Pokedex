package com.example.pokedex2.model.data

import androidx.compose.ui.graphics.Color

enum class TypeColor(val color: Color) {
    NORMAL(Color(0xff9199A1)),
    FIRE(Color(0xffFC9B50)),
    WATER(Color(0xff4D8FD6)),
    GRASS(Color(0xff65BB5C)),
    FIGHTING(Color(0xffD13F6C)),
    FLYING(Color(0xff92AADD)),
    BUG(Color(0xff92C12B)),
    GROUND(Color(0xffD97644)),
    ROCK(Color(0xffC8B68D)),
    STEEL(Color(0xff598C9D)),
    GHOST(Color(0xff5369B1)),
    DARK(Color(0xff595464)),
    FAIRY(Color(0xffE990E5)),
    DRAGON(Color(0xff0A6CC3)),
    ICE(Color(0xff74CFC0)),
    ELECTRIC(Color(0xffF4D239)),
    PSYQUIC(Color(0xffF97075)),
    POISON(Color(0xffAB6CC9))
}

data class Type(
    val name:String = "",

)