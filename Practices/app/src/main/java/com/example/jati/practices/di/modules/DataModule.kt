package com.example.jati.practices.di.modules

import android.app.Application
import com.example.jati.practices.entity.PracticesAppDatabase
import com.example.jati.practices.entity.dao.HistoryDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Jati on 16/08/18.
 */

@Module
class DataModule {

    @Provides
    @Singleton
    fun providesHistoryDao(app: Application): HistoryDao = PracticesAppDatabase.getInstance(app).historyDao()
}