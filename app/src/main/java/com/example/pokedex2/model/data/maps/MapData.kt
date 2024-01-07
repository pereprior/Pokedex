package com.example.pokedex2.model.data.maps

import com.example.pokedex2.R

object MapData {
    private val imageList = listOf(
        R.drawable.mapaalola,
        R.drawable.mapagalar,
        R.drawable.mapahoenn,
        R.drawable.mapajhoto,
        R.drawable.mapakalos,
        R.drawable.mapakanto,
        R.drawable.mapapaldea,
        R.drawable.mapasinnoh,
        R.drawable.mapateselia
    )

    private val mapNames = listOf(
        "Alola",
        "Galar",
        "Hoenn",
        "Jhoto",
        "Kalos",
        "Kanto",
        "Paldea",
        "Sinnoh",
        "Teselia"
    )

    val testmapsData: List<TestDataItem> by lazy {
        generateTestData()
    }

    private fun generateTestData(): List<TestDataItem> {
        return imageList.mapIndexed { index, drawable ->
            TestDataItem(
                id = (index + 1).toString(),
                title = mapNames[index],
                drawable = drawable
            )
        }
    }
}