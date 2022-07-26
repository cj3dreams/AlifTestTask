package com.cj3dreams.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cj3dreams.data.db.dao.DataDao
import com.cj3dreams.data.db.entity.DataEntity

@Database(entities = [DataEntity::class], version = 1, exportSchema = false)
abstract class RoomAppDb: RoomDatabase() {

    abstract fun dataDao(): DataDao
}