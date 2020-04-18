package com.jml.breaking.bad.characters.domain.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.jml.breaking.bad.characters.data.CharactersRepository
import com.jml.breaking.bad.characters.domain.model.CharacterSeries
import com.jml.breaking.bad.common.domain.vm.BaseViewModel
import com.jml.breaking.bad.common.extensions.log

class CharactersViewModel(
    private val charactersRepo: CharactersRepository
) : BaseViewModel(){

    init {
        log("Has started the CharactersViewModel")
    }
    val characters: LiveData<List<CharacterSeries>> = liveData {
        emit(charactersRepo.getCharacters())
    }
}