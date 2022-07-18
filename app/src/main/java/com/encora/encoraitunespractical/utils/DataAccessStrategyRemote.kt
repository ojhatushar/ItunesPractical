package com.encora.encoraitunespractical.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.encora.encoraitunespractical.utils.statusUtils.Resource
import com.encora.encoraitunespractical.utils.statusUtils.Status


import kotlinx.coroutines.Dispatchers

/*
    * 1. First we need to let our LiveData know that we are looking for the data, so first state is Loading
    * 2. Then it first looks in database for data,if found than state change to success
    * 3. We also want to keep our app synced so we are fetching data from internet as well
    * 4.  Finally we need to save our result from the remote call in the database,so that data remains updated
*/
fun <T, A> performGetOperation(
    databaseQuery: () -> LiveData<T>,
    networkCall: suspend () -> Resource<A>,
    saveCallResult: suspend (A) -> Unit,
): LiveData<Resource<T>> =
    liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val source = databaseQuery.invoke().map { Resource.success(it) }
        emitSource(source)

        val responseStatus = networkCall.invoke()
        if (responseStatus.status == Status.SUCCESS) {
            saveCallResult(responseStatus.data!!)

        } else if (responseStatus.status == Status.ERROR) {
            emit(Resource.error(responseStatus.message!!))
            emitSource(source)
        }
    }


