package com.example.pokedex2.model.data.convert

import androidx.compose.ui.graphics.Color
import com.example.pokedex2.model.api.response.type.TypeInfo
import com.example.pokedex2.ui.theme.TypesColor

class Type(private val t:TypeInfo = TypeInfo()) {
    val id:Int = t.id

    val name:String = t.name

    val color:Color = getColor(name)

    val strongFrom:List<String> = t.damage_relations.double_damage_from.map { it.name }

    val strongTo:List<String> = t.damage_relations.double_damage_to.map { it.name }

    val weakFrom:List<String> = t.damage_relations.half_damage_from.map { it.name }

    val weakTo:List<String> = t.damage_relations.half_damage_to.map { it.name }

    val inmmunityFrom:List<String> = t.damage_relations.no_damage_from.map { it.name }

    val inmunityTo:List<String> = t.damage_relations.no_damage_to.map { it.name }
}

private fun getColor(name:String):Color{
    var color = Color.Transparent

    for (e in TypesColor){
        if (e.name == name){
            color = e.color
        }
    }

    return color
}