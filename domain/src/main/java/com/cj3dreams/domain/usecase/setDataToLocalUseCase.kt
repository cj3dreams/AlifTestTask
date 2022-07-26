package com.cj3dreams.domain.usecase

import com.cj3dreams.domain.model.PreDataEntity
import com.cj3dreams.domain.repositories.DataRepository

class setDataToLocalUseCase (private val dataRepository: DataRepository) {
    suspend operator fun invoke(list: PreDataEntity) = dataRepository.setData(list)
}