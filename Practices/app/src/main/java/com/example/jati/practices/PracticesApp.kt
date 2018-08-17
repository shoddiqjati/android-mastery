package com.example.jati.practices

import android.app.Application
import com.example.jati.practices.di.components.AppComponent
import com.example.jati.practices.di.components.DaggerAppComponent
import com.example.jati.practices.di.modules.AppModule
import com.example.jati.practices.di.modules.DataModule

/**
 * Created by Jati on 16/08/18.
 */

class PracticesApp : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .dataModule(DataModule())
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}