package com.example.pokedex2.model.data.convert

import com.example.pokedex2.model.api.response.item.ItemInfo
import com.example.pokedex2.ui.components.theme.LANGUAGE_KEY

class Item(i: ItemInfo = ItemInfo()) {
    val id:Int = i.id

    val name:String = i.name

    val category:String = i.category.name

    val description:String = getDescription(i)

    val effect:String = getEffect(i)

    val image:String = i.sprites.default
}

private fun getDescription(i:ItemInfo):String{
    var result = ""

    for (e in i.flavor_text_entries){
        if (e.language.name == LANGUAGE_KEY) {
            result = e.text
        }
    }

    return result
}

private fun getEffect(i:ItemInfo):String{
    var result = ""

    for (e in i.effect_entries){
        if (e.language.name == LANGUAGE_KEY) {
            result = e.effect
        }
    }

    return result
}