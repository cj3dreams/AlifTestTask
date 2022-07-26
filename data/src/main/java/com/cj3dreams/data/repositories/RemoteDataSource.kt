package com.cj3dreams.data.repositories

import com.cj3dreams.domain.common.Result
import com.cj3dreams.domain.model.PreDataEntity

interface RemoteDataSource {
    suspend fun getAllData(): Result<List<PreDataEntity>>
}