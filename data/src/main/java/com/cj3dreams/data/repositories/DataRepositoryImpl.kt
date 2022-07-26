package com.cj3dreams.data.repositories

import com.cj3dreams.domain.common.Result
import com.cj3dreams.domain.model.PreDataEntity
import com.cj3dreams.domain.repositories.DataRepository

class DataRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
): DataRepository {
    override suspend fun getAllDataRemote(): Result<List<PreDataEntity>> = remoteDataSource.getAllData()

    override suspend fun getAllDataLocal(): List<PreDataEntity> = localDataSource.getAllDataLocal()

    override suspend fun setData(list: List<PreDataEntity>) = localDataSource.setData(list)
}