package com.jml.breaking.bad.di

import org.koin.dsl.module

val appModule = module {

    //viewModel { ExampleViewModel(get()) }
}

val useCaseModule = module {
    //factory { GetExamplesUseCase(get()) }
}

val repositoryModule = module {
    //single<ExampleRepository> { ExampleRepositoryImpl(get()) }

    //factory { ExampleDataSource(get()) }
}

