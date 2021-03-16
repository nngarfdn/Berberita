package com.nanang.retrocoro.data.repository

import androidx.lifecycle.liveData
import com.nanang.berberita.api.ApiHelper
import kotlinx.coroutines.Dispatchers

class MainRepository(private val apiHelper : ApiHelper) {

   suspend fun getUsers() = apiHelper.getTopNews()
}