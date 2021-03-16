package com.nanang.retrocoro.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.nanang.berberita.utils.Resource
import com.nanang.retrocoro.data.repository.MainRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {
    fun  getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        }catch (e : Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occurred!"))
        }
    }
}