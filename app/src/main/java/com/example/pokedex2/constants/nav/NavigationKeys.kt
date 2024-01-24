package com.example.pokedex2.constants.nav

const val POKEMON_NAVIGATION_PACKAGE = "PokemonView"
const val POKEMON_NAVIGATION_LIST = "Pokedex"

fun getAbsoluteNavigationPath(navigationPackage: String, navigationList: String): String {
    return "$navigationPackage/$navigationList"
}