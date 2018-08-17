package com.example.jati.practices.di.components

import android.app.Application
import com.example.jati.practices.di.modules.AppModule
import com.example.jati.practices.di.modules.DataModule
import com.example.jati.practices.ui.MainActivity
import com.example.jati.practices.ui.history.HistoryFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Jati on 16/08/18.
 */

@Singleton
@Component(modules = [(DataModule::class), (AppModule::class)])
interface AppComponent {
    fun inject(app: Application)
    fun inject(mainActivity: MainActivity)
    fun inject(historyFragment: HistoryFragment)
}