package com.cj3dreams.data.db.dao

import androidx.room.*
import com.cj3dreams.data.db.entity.DataEntity

@Dao
interface DataDao {

    @Query("SELECT * FROM dataEntity ORDER by id DESC")
    fun getAllData(): List<DataEntity>

    @Query("SELECT * FROM dataEntity ORDER BY id ASC LIMIT :limit OFFSET :offset")
    suspend fun getPagedList(limit: Int, offset: Int): List<DataEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDataList(newsEntity: List<DataEntity>)

    @Query("DELETE FROM dataEntity")
    suspend fun deleteAllData()

    @Update
    suspend fun updateData(newsEntity: DataEntity)
}