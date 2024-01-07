package com.example.pokedex2.model.data.convert

import com.example.pokedex2.model.api.response.move.MoveInfo
import com.example.pokedex2.ui.theme.LANGUAGE_KEY

class Move(m: MoveInfo = MoveInfo()) {
    val id:Int = m.id

    val name:String = m.name

    val description:String = getDescription(m)

    val effect:String = getEffect(m)

    val type:String = m.type.name

    val category:String = m.damage_class.name

    val power:Int = m.power

    val accuracy:Int = m.accuracy

    val pp:Int = m.pp

    val priority:Int = m.priority

    val learnedBy:List<String> = m.learned_by_pokemon.map { it.name }
}

private fun getDescription(m:MoveInfo):String{
    val result = ""

    for (e in m.flavor_text_entries){
        if (e.language.name == LANGUAGE_KEY) {
            return e.flavor_text
        }
    }

    return result
}

private fun getEffect(m:MoveInfo):String{
    var result = ""

    for (e in m.effect_entries){
        if (e.language.name == LANGUAGE_KEY) {
            result = e.effect
        }
    }

    return result
}