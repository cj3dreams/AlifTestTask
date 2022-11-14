package com.cj3dreams.data.repositories

import com.cj3dreams.data.db.dao.DataDao
import com.cj3dreams.data.mappers.DataEntityMapper
import com.cj3dreams.domain.model.PreDataEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSourceImpl
    (private val dataDao: DataDao,
    private val dataEntityMapper: DataEntityMapper): LocalDataSource {
    override suspend fun getAllDataLocal(): List<PreDataEntity> = withContext(Dispatchers.IO){
        val allData = dataDao.getAllData()
        return@withContext allData.map {
            dataEntityMapper.toPreDataEntity(it)
        }
    }

    override suspend fun getAllDataLocalWithPaging(limit: Int, offset: Int):
            List<PreDataEntity> = withContext(Dispatchers.IO){
        val allData = dataDao.getPagedList(limit, offset)
        return@withContext allData.map {
            dataEntityMapper.toPreDataEntity(it)
        }
    }

    override suspend fun setData(list: List<PreDataEntity>) = withContext(Dispatchers.IO){
        val allData = list.map {
            dataEntityMapper.toDataEntity(it)
        }
        dataDao.insertDataList(allData)
    }
}