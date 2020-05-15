package com.jml.breaking.bad.di

import android.content.Context
import com.jml.breaking.bad.BuildConfig
import com.jml.breaking.bad.characters.data.datasource.CharactersApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.logging.Logger

val networkModule = module {

    single { provideDefaultOkhttpClient(get()) }
    single { provideRetrofit(get()) }
    single { provideCharactersApi(get()) }
}

fun provideDefaultOkhttpClient(context: Context): OkHttpClient {
    val cacheSize = (5 * 1024 * 1024).toLong()

    val cache = Cache(context.cacheDir, cacheSize)
    return OkHttpClient.Builder()
        .cache(cache)
        .addInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .build()
}

fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.SERVER_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()
}

fun provideCharactersApi(retrofit: Retrofit): CharactersApi =
    retrofit.create(CharactersApi::class.java)


