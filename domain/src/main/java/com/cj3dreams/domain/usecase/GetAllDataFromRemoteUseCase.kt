package com.cj3dreams.domain.usecase

import com.cj3dreams.domain.repositories.DataRepository

class GetAllDataFromRemoteUseCase(private val dataRepository: DataRepository) {
    suspend operator fun invoke() = dataRepository.getAllDataRemote()
}