package com.jml.breaking.bad.characters.data.datasource

import  com.jml.breaking.bad.characters.data.model.CharacterResponse
import retrofit2.http.GET

interface CharactersApi {

    @GET("characters")
    suspend fun getCharacters(): List<CharacterResponse>
}