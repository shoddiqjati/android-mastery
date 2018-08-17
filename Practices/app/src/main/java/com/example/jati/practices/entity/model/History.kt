package com.example.jati.practices.entity.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Jati on 16/08/18.
 */

@Entity(tableName = "history")
class History(
        @ColumnInfo(name = "category")
        val category: String,
        @ColumnInfo(name = "status")
        val status: Boolean,
        @ColumnInfo(name = "datetime")
        val datetime: String,
        @ColumnInfo(name = "address")
        val address: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}