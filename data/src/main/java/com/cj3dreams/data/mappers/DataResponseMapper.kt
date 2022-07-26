package com.cj3dreams.data.mappers

import com.cj3dreams.domain.model.DataResponse
import com.cj3dreams.domain.model.PreDataEntity

class DataResponseMapper {
    fun toPreDataEntityList(response: DataResponse): List<PreDataEntity> {
        return response.data.map {
            PreDataEntity(
                id = 0,
                endDate = it.endDate,
                icon = it.icon,
                loginRequired = if(it.loginRequired) 1 else 0,
                name = it.name,
                objType = it.objType,
                startDate = it.startDate,
                url = it.url
                )
        }
    }
}