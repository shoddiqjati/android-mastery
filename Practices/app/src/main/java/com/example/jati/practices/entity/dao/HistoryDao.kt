package com.example.jati.practices.entity.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.example.jati.practices.entity.model.History

/**
 * Created by Jati on 16/08/18.
 */

@Dao
interface HistoryDao {
    @Query("select * from history order by id")
    fun getAllHistory(): LiveData<List<History>>

    @Query("select * from history where id = :id")
    fun getHistory(id: Int): History

    @Insert(onConflict = REPLACE)
    fun addHistory(history: History)

    @Delete
    fun deleteHistory(history: History)
}