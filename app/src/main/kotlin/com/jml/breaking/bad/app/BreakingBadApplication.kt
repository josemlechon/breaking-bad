package com.jml.breaking.bad.app

import android.app.Application
import com.jml.breaking.bad.di.appModule
import com.jml.breaking.bad.di.networkModule
import com.jml.breaking.bad.di.repositoryModule
import com.jml.breaking.bad.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BreakingBadApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startDI()
    }

    private fun startDI() {

        startKoin {
            androidLogger()
            androidContext(this@BreakingBadApplication)
            modules(
                appModule,
                useCaseModule,
                repositoryModule,
                networkModule
            )
        }
    }
}