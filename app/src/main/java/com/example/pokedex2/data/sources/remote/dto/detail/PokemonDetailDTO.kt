package com.example.pokedex2.data.sources.remote.dto.detail

import com.google.gson.annotations.SerializedName

data class PokemonDetailDTO(
    @SerializedName("abilities")
    val abilities: List<AbilityDTO>,

    @SerializedName("base_experience")
    val baseExperience: Int,

    @SerializedName("forms")
    val forms: List<Form>,

    @SerializedName("game_indices")
    val gameIndices: List<GameIndice>,

    @SerializedName("height")
    val height: Int,

    @SerializedName("held_items")
    val heldItems: List<Any>,

    @SerializedName("id")
    val id: Int,

    @SerializedName("is_default")
    val isDefault: Boolean,

    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String,

    @SerializedName("moves")
    val moves: List<MoveDTO>,

    @SerializedName("name")
    val name: String,

    @SerializedName("order")
    val order: Int,

    @SerializedName("past_abilities")
    val pastAbilities: List<Any>,

    @SerializedName("past_types")
    val pastTypes: List<Any>,

    @SerializedName("species")
    val species: Species,

    @SerializedName("sprites")
    val sprites: Sprites,

    @SerializedName("stats")
    val stats: List<StatDTO>,

    @SerializedName("types")
    val types: List<TypeDTO>,

    @SerializedName("weight")
    val weight: Int
)