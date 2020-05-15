package com.jml.breaking.bad.di

import com.jml.breaking.bad.characters.data.CharactersRepository
import com.jml.breaking.bad.characters.domain.vm.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { CharactersViewModel(get()) }
}

val repositoryModule = module {
    single<CharactersRepository> { CharactersRepository(get()) }
}

