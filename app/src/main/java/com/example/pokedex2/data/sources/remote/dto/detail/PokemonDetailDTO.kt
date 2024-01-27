package com.example.pokedex2.data.sources.remote.dto.detail

import com.squareup.moshi.Json

data class PokemonDetailDTO(
    @field:Json(name = "abilities")
    val abilities: List<AbilityDTO>,

    @field:Json(name = "base_experience")
    val baseExperience: Int,

    @field:Json(name = "forms")
    val forms: List<Form>,

    @field:Json(name = "game_indices")
    val gameIndices: List<GameIndice>,

    @field:Json(name = "height")
    val height: Int,

    @field:Json(name = "held_items")
    val heldItems: List<Any>,

    @field:Json(name = "id")
    val id: Int,

    @field:Json(name = "is_default")
    val isDefault: Boolean,

    @field:Json(name = "location_area_encounters")
    val locationAreaEncounters: String,

    @field:Json(name = "moves")
    val moves: List<MoveDTO>,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "order")
    val order: Int,

    @field:Json(name = "past_abilities")
    val pastAbilities: List<Any>,

    @field:Json(name = "past_types")
    val pastTypes: List<Any>,

    @field:Json(name = "species")
    val species: Species,

    @field:Json(name = "sprites")
    val sprites: Sprites,

    @field:Json(name = "stats")
    val stats: List<StatDTO>,

    @field:Json(name = "types")
    val types: List<TypeDTO>,

    @field:Json(name = "weight")
    val weight: Int
)