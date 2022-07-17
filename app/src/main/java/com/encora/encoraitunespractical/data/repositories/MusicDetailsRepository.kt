package com.encora.encoraitunespractical.data.repositories

import com.encora.encoraitunespractical.data.remote.ApiHelper
import com.encora.encoraitunespractical.utils.performGetOperation
import com.encora.encoraitunespractical.data.db.AppDatabase
import com.encora.encoraitunespractical.utils.extensions.convertToSongsBean
import javax.inject.Inject

//Repository for database and retrofit purpose
class MusicDetailsRepository @Inject constructor(
    private val appDatabase: AppDatabase,
    private val apiHelper: ApiHelper,
) {

    fun getMusicDetails() =
        performGetOperation(
            databaseQuery = { appDatabase.musicDetailsDao().getallSongs() },
            networkCall = { apiHelper.getItunesDetails() },
            saveCallResult = {
                appDatabase.musicDetailsDao()
                    .addAllSongs(it.entries!!.map { entry->
                        entry.convertToSongsBean() }
                    )
            })

}
