package com.cj3dreams.domain.usecase

import com.cj3dreams.domain.repositories.DataRepository

class GetAllDataFromLocalWithPagingUseCase (private val dataRepository: DataRepository) {
    suspend operator fun invoke(limit: Int, offset: Int) =
        dataRepository.getAllDataLocalWithPaging(limit, offset)
}