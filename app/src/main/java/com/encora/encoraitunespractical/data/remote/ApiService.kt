package com.encora.encoraitunespractical.data.remote


import com.encora.encoraitunespractical.data.model.obj.xmlobj.Feed
import com.encora.encoraitunespractical.utils.Constants.DATA_FORMAT
import com.encora.encoraitunespractical.utils.Constants.DATA_LIMIT
import com.encora.encoraitunespractical.utils.Constants.END_POINT

import retrofit2.http.*


interface ApiService {

    @GET("$END_POINT/$DATA_LIMIT$DATA_FORMAT")
    suspend fun getItunesDetails(): Feed
}