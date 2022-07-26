package com.cj3dreams.data.repositories

import com.cj3dreams.data.api.DataApi
import com.cj3dreams.data.mappers.DataResponseMapper
import com.cj3dreams.domain.model.PreDataEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.cj3dreams.domain.common.Result

class RemoteDataSourceImpl(
    private val dataApi: DataApi,
    private val mapper: DataResponseMapper
): RemoteDataSource {
    override suspend fun getAllData(): Result<List<PreDataEntity>> = withContext(Dispatchers.IO){
        try {
            val response = dataApi.getAllData()
            if (response.isSuccessful) return@withContext Result.Success((mapper.toPreDataEntityList(response.body()!!)))

            else return@withContext Result.Error(Exception(response.message()))
        }catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }
}