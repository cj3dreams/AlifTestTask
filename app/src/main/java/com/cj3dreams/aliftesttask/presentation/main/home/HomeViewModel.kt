package com.cj3dreams.aliftesttask.presentation.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.cj3dreams.data.pagination.DataPagingSource
import com.cj3dreams.data.repositories.DataRepositoryImpl
import com.cj3dreams.domain.common.Result
import com.cj3dreams.domain.usecase.GetAllDataFromLocalUserCase
import com.cj3dreams.domain.usecase.GetAllDataFromLocalWithPagingUseCase
import com.cj3dreams.domain.usecase.GetAllDataFromRemoteUseCase
import com.cj3dreams.domain.usecase.SetDataToLocalUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val dataRepository: DataRepositoryImpl): ViewModel() {

    private val getAllDataFromRemoteUseCase get() = GetAllDataFromRemoteUseCase(dataRepository)
    private val getAllDataFromLocalUserCase get() = GetAllDataFromLocalUserCase(dataRepository)
    private val getAllDataFromLocalWithPagingUseCase get() = GetAllDataFromLocalWithPagingUseCase(dataRepository)
    private val setDataToLocalUserCase get() = SetDataToLocalUseCase(dataRepository)

    var isDbEmpty: MutableLiveData<Boolean> = MutableLiveData(true)

    fun getAll() = viewModelScope.launch(Dispatchers.IO) {
        when (val dataResult = getAllDataFromRemoteUseCase.invoke()){
            is Result.Success -> setDataToLocalUserCase.invoke(dataResult.data)
            is Result.Error -> {}

        }
    }
    suspend fun refreshIsDbEmpty() = isDbEmpty.postValue(getAllDataFromLocalUserCase.invoke().isEmpty())

    fun getFromPagingDataSource() =
        Pager(
            PagingConfig(
                pageSize = 3,
                enablePlaceholders = false,
                initialLoadSize = 3),) {
            DataPagingSource(getAllDataFromLocalWithPagingUseCase)
        }.liveData.cachedIn(viewModelScope)
}