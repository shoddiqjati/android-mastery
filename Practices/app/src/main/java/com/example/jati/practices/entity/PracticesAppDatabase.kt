package com.example.jati.practices.entity

import android.app.Application
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.jati.practices.entity.dao.HistoryDao
import com.example.jati.practices.entity.model.History

/**
 * Created by Jati on 16/08/18.
 */

@Database(entities = [History::class], version = 1)
abstract class PracticesAppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao

    companion object {
        @Volatile
        private var INSTANCE: PracticesAppDatabase? = null

        @JvmStatic
        fun getInstance(app: Application): PracticesAppDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(app).also { INSTANCE = it }
                }

        private fun buildDatabase(app: Application) =
                Room.databaseBuilder(app.applicationContext,
                        PracticesAppDatabase::class.java, "practices.db")
                        .allowMainThreadQueries()
                        .build()
    }
}