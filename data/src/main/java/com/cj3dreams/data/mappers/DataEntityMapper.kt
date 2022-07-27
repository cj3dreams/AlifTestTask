package com.cj3dreams.data.mappers

import com.cj3dreams.data.db.entity.DataEntity
import com.cj3dreams.domain.model.PreDataEntity

class DataEntityMapper {
    fun toDataEntity(preDataEntity: PreDataEntity) = DataEntity(
        id = 0,
        endDate = preDataEntity.endDate,
        icon = preDataEntity.icon,
        loginRequired = preDataEntity.loginRequired,
        name = preDataEntity.name,
        objType = preDataEntity.objType,
        startDate = preDataEntity.startDate,
        url = preDataEntity.url)

    fun toPreDataEntity(dataEntity: DataEntity) = PreDataEntity(
        id = 0,
        endDate = dataEntity.endDate,
        icon = dataEntity.icon,
        loginRequired = dataEntity.loginRequired,
        name = dataEntity.name,
        objType = dataEntity.objType,
        startDate = dataEntity.startDate,
        url = dataEntity.url)
}