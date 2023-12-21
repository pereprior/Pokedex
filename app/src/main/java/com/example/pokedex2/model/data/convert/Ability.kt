package com.example.pokedex2.model.data.convert

import com.example.pokedex2.model.api.response.ability.AbilityInfo
import com.example.pokedex2.ui.theme.LANGUAGE_KEY

class Ability(private val a:AbilityInfo = AbilityInfo()) {
    val id:Int = a.id

    val name:String = a.name

    val owners:List<String> = a.pokemon.map { it.pokemon.name }

    val description:String = getDescription(a)

    val effect:String = getEffect(a)
}

private fun getDescription(a:AbilityInfo):String{
    var result = ""

    for (e in a.flavor_text_entries){
        if (e.language.name == LANGUAGE_KEY) {
            result = e.flavor_text
        }
    }

    return result
}

private fun getEffect(a:AbilityInfo):String{
    var result = ""

    for (e in a.effect_entries){
        if (e.language.name == LANGUAGE_KEY) {
            result = e.effect
        }
    }

    return result
}