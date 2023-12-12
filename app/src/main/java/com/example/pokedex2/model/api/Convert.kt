package com.example.pokedex2.model.api

import com.example.pokedex2.model.api.pokemon.PokemonResult
import com.example.pokedex2.model.api.type.TypeResult
import com.example.pokedex2.model.data.Pokemon
import com.example.pokedex2.model.data.Type

class Convert {
    fun pokemon(p: PokemonResult): Pokemon {
        return Pokemon(
            name = p.name
        )
    }

    fun type(p: TypeResult): Type {
        return Type(
            
        )
    }

}