package com.jml.breaking.bad.characters.data

import com.jml.breaking.bad.characters.data.datasource.CharactersApi
import com.jml.breaking.bad.characters.domain.model.CharacterSeries
import okhttp3.internal.wait

class CharactersRepository ( private val charactersApi: CharactersApi) {


    suspend fun getCharacters(): List<CharacterSeries>{
        return charactersApi.getCharacters()
            .map (CharactersMapper::mapCharactersResponseToModel)
    }
}