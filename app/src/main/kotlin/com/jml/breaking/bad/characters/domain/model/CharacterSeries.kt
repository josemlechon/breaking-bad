package com.jml.breaking.bad.characters.domain.model

import com.google.gson.annotations.SerializedName

data class CharacterSeries(
    val id: String,
    val name: String,
    val birthday: String,
    val occupations: List<String>,
    val image: String,
    val status: String,
    val nickname: String,
    val appearance: List<String>,
    val portrayed: String,
    val category: String
)