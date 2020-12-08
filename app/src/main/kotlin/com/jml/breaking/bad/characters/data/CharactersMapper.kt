package com.jml.breaking.bad.characters.data

import com.jml.breaking.bad.characters.data.model.CharacterResponse
import com.jml.breaking.bad.characters.domain.model.CharacterSeries

object CharactersMapper {

    fun mapCharactersResponseToModel(response: CharacterResponse): CharacterSeries =
        response.let { item ->
            CharacterSeries(
                id = item.id.toString(),
                name = item.name.orEmpty(),
                nickname = item.nickname.orEmpty(),
                birthday = item.birthday.orEmpty(),
                image = item.image.orEmpty(),
                appearance = item.appearance.orEmpty(),
                category = item.category.orEmpty(),
                status = item.status.orEmpty(),
                occupations = item.occupations.orEmpty(),
                portrayed = item.portrayed.orEmpty()
            )
        }
    //todo this is a test for sonarcloud
}