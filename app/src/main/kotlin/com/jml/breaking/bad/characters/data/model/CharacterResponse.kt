package com.jml.breaking.bad.characters.data.model

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("char_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("birthday") val birthday: String,
    @SerializedName("occupation") val occupations: List<String>,
    @SerializedName("img") val image: String,
    @SerializedName("status") val status: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("appearance") val appearance: List<String>,
    @SerializedName("portrayed") val portrayed: String,
    @SerializedName("category") val category: String
)