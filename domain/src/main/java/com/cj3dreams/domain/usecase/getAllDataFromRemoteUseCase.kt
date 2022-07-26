package com.cj3dreams.domain.usecase

import com.cj3dreams.domain.repositories.DataRepository

class getAllDataFromRemoteUseCase(private val dataRepository: DataRepository) {
    suspend operator fun invoke() = dataRepository.getAllDataRemote()
}