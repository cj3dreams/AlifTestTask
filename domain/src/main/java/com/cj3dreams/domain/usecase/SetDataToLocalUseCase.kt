package com.cj3dreams.domain.usecase

import com.cj3dreams.domain.model.PreDataEntity
import com.cj3dreams.domain.repositories.DataRepository

class SetDataToLocalUseCase (private val dataRepository: DataRepository) {
    suspend operator fun invoke(list: List<PreDataEntity>) = dataRepository.setData(list)
}