package com.cj3dreams.data.db.dao

import androidx.room.*
import com.cj3dreams.data.db.entity.DataEntity

@Dao
interface DataDao {

    @Query("SELECT * FROM dataEntity ORDER by id DESC")
    fun getAllData(): List<DataEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataList(newsEntity: List<DataEntity>)

    @Query("DELETE FROM dataEntity")
    suspend fun deleteAllData()

    @Update
    suspend fun updateData(newsEntity: DataEntity)
}