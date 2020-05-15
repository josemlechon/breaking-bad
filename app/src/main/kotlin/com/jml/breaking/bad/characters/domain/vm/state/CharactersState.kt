package com.jml.breaking.bad.characters.domain.vm.state

import com.jml.breaking.bad.characters.domain.model.CharacterSeries

sealed class CharactersState {
    class Data(val data: List<CharacterSeries>) : CharactersState()
    object Error : CharactersState()
}