package com.cj3dreams.domain.repositories

import com.cj3dreams.domain.common.Result
import com.cj3dreams.domain.model.PreDataEntity

interface DataRepository {

    suspend fun getAllDataRemote(): Result<List<PreDataEntity>>
    suspend fun getAllDataLocal(): List<PreDataEntity>
    suspend fun getAllDataLocalWithPaging(limit: Int, offset: Int): List<PreDataEntity>
    suspend fun setData(list: List<PreDataEntity>)
}