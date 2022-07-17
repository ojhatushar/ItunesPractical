package com.encora.encoraitunespractical.data.remote


import com.encora.encoraitunespractical.data.model.responseModel.Feed
import com.encora.encoraitunespractical.utils.Constants.DATA_FORMAT
import com.encora.encoraitunespractical.utils.Constants.DATA_LIMIT
import com.encora.encoraitunespractical.utils.Constants.END_POINT
import com.encora.encoraitunespractical.utils.Constants.MIDDLE_PART

import retrofit2.http.*


interface ApiService {

    @GET("$MIDDLE_PART$END_POINT/$DATA_LIMIT$DATA_FORMAT")
    suspend fun getItunesDetails(): Feed
}