package com.jml.breaking.bad.characters.data.model


import com.squareup.moshi.Json

data class CharacterResponse(
    @field:Json(name = "char_id") val id: Int,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "birthday") val birthday: String?,
    @field:Json(name = "occupation") val occupations: List<String>?,
    @field:Json(name = "img") val image: String?,
    @field:Json(name = "status") val status: String?,
    @field:Json(name = "nickname") val nickname: String?,
    @field:Json(name = "appearance") val appearance: List<String>?,
    @field:Json(name = "portrayed") val portrayed: String?,
    @field:Json(name = "category") val category: String?
)