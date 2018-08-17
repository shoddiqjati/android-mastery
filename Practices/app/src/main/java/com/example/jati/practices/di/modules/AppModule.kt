package com.example.jati.practices.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Jati on 17/08/18.
 */

@Module
class AppModule(val app: Application) {

    @Provides
    @Singleton
    fun provideAppModule(): Application = app
}