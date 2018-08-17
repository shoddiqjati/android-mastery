package com.example.jati.practices.ui.history

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.jati.practices.entity.dao.HistoryDao
import com.example.jati.practices.entity.model.History
import javax.inject.Inject

/**
 * Created by Jati on 16/08/18.
 */

class HistoryViewModel @Inject constructor(application: Application,
                                           private val historyDao: HistoryDao) : AndroidViewModel(application) {

    fun loadHistory(): LiveData<List<History>> = historyDao.getAllHistory()

    fun addHistory(history: History) {
        historyDao.addHistory(history)
    }
}