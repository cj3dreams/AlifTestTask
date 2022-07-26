package com.cj3dreams.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName =  "dataEntity", indices =
[Index(value = ["url"], unique = true)])
data class DataEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "endDate")
    val endDate: String,
    @ColumnInfo(name = "icon")
    val icon: String,
    @ColumnInfo(name = "loginRequired")
    val loginRequired: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "objType")
    val objType: String,
    @ColumnInfo(name = "startDate")
    val startDate: String,
    @ColumnInfo(name = "url")
    val url: String,
        )