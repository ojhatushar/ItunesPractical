package com.encora.encoraitunespractical.data.remote

import com.encora.encoraitunespractical.data.remote.ApiService
import com.encora.encoraitunespractical.data.remote.BaseDataSource
import javax.inject.Inject

class ApiHelper @Inject constructor(private val apiService: ApiService) : BaseDataSource() {

    suspend fun getItunesDetails() =
        getResult { apiService.getItunesDetails() }

}