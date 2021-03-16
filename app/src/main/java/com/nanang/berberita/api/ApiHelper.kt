package com.nanang.berberita.api

import com.nanang.berberita.data.api.ApiService

class ApiHelper(private val apiService: ApiService) {
    suspend fun getTopNews() = apiService.getTopNews()
}