package com.jml.breaking.bad.di

import android.content.Context
import com.jml.breaking.bad.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit


val networkModule = module {

    single { provideDefaultOkhttpClient(get()) }
    single { provideRetrofit(get()) }
    //single { provideExampleApi(get()) }
}

fun provideDefaultOkhttpClient(context: Context): OkHttpClient {
    val cacheSize = (5 * 1024 * 1024).toLong()

    val cache = Cache(context.cacheDir, cacheSize)
    return OkHttpClient.Builder()
        .cache(cache)
        .addInterceptor(HttpLoggingInterceptor())
        .build()
}

fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.SERVER_BASE_URL)
        .client(client)
        .build()
}

//fun provideExampleApi(retrofit: Retrofit): ExamplesApi = retrofit.create(ExamplesApi::class.java)


