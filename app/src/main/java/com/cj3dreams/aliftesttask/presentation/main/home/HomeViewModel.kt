package com.cj3dreams.aliftesttask.presentation.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cj3dreams.data.repositories.DataRepositoryImpl
import com.cj3dreams.domain.common.Result
import com.cj3dreams.domain.model.PreDataEntity
import com.cj3dreams.domain.usecase.GetAllDataFromLocalUserCase
import com.cj3dreams.domain.usecase.GetAllDataFromRemoteUseCase
import com.cj3dreams.domain.usecase.SetDataToLocalUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val dataRepository: DataRepositoryImpl): ViewModel() {
    val mutableLiveData = MutableLiveData<List<PreDataEntity>>()

    private val getAllDataFromRemoteUseCase get() = GetAllDataFromRemoteUseCase(dataRepository)
    private val getAllDataFromLocalUserCase get() = GetAllDataFromLocalUserCase(dataRepository)
    private val setDataToLocalUserCase get() = SetDataToLocalUseCase(dataRepository)


    fun getAll() = viewModelScope.launch(Dispatchers.IO) {
        when (val dataResult = getAllDataFromRemoteUseCase.invoke()){
            is Result.Success -> setDataToLocalUserCase.invoke(dataResult.data)
            is Result.Error -> setDataToLocalUserCase.invoke(emptyList())
        }
        mutableLiveData.postValue(getAllDataFromLocalUserCase.invoke())
    }
}