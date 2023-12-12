package com.example.pokedex2.viewModel

import com.example.pokedex2.model.api.ability.Ability
import com.example.pokedex2.model.api.ability.Generation
import com.example.pokedex2.model.api.move.ContestCombos
import com.example.pokedex2.model.api.move.ContestEffect
import com.example.pokedex2.model.api.move.ContestType
import com.example.pokedex2.model.api.move.DamageClass
import com.example.pokedex2.model.api.move.Meta
import com.example.pokedex2.model.api.move.Move
import com.example.pokedex2.model.api.move.Normal
import com.example.pokedex2.model.api.move.Super
import com.example.pokedex2.model.api.pokemon.Pokemon
import com.example.pokedex2.model.api.pokemon.Species
import com.example.pokedex2.model.api.pokemon.Sprites
import com.example.pokedex2.model.api.type.DamageRelations
import com.example.pokedex2.model.api.type.GenerationX
import com.example.pokedex2.model.api.type.MoveDamageClass
import com.example.pokedex2.model.api.type.Type

data class MainState(
    val isLoading: Boolean = false,
    val pokemon: Pokemon = Pokemon(emptyList(),0,emptyList(),emptyList(),0,emptyList(),0,true,"", emptyList(),"",0, emptyList(), emptyList(), Species("",""), Sprites("","","","","","","",""), emptyList(), emptyList(),0),
    val type: Type = Type(DamageRelations(emptyList(), emptyList(), emptyList(), emptyList(), emptyList(), emptyList()), emptyList(), GenerationX("",""), 0, MoveDamageClass("",""), emptyList(), "", emptyList(), emptyList(), emptyList()),
    val ability: Ability = Ability(emptyList(), emptyList(), emptyList(), Generation("",""), 0,true,"", emptyList(), emptyList()),
    /*val move: Move = Move(0, ContestCombos(Normal("", emptyList()), Super("","")), ContestEffect(""),
        ContestType("",""), DamageClass("",""),"", emptyList(), emptyList(), emptyList(),com.example.pokedex2.model.api.move.Generation("",""),0,
        emptyList(),
        emptyList(),
        Meta()
    )*/
)