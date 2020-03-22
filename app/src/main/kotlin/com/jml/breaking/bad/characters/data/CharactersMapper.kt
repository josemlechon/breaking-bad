package com.jml.breaking.bad.characters.data

import com.jml.breaking.bad.characters.data.model.CharacterResponse
import com.jml.breaking.bad.characters.domain.model.CharacterSeries

object CharactersMapper {

    fun mapCharactersResponseToModel(response: CharacterResponse): CharacterSeries {

        return response.let { item ->
            CharacterSeries(
                id = item.id,
                name = item.name,
                nickname = item.nickname,
                birthday = item.birthday,
                image = item.image,
                appearance = item.appearance,
                category = item.category,
                status = item.status,
                occupations = item.occupations,
                portrayed = item.portrayed
            )
        }
    }
}