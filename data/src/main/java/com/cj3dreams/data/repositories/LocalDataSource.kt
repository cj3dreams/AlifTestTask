package com.cj3dreams.data.repositories

import com.cj3dreams.domain.model.PreDataEntity

interface LocalDataSource {
    suspend fun getAllDataLocal(): List<PreDataEntity>

    suspend fun setData(list: List<PreDataEntity>)
}