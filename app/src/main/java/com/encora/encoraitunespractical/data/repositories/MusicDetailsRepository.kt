package com.encora.encoraitunespractical.data.repositories

import com.encora.encoraitunespractical.data.remote.ApiHelper
import com.encora.encoraitunespractical.utils.performGetOperation
import com.encora.encoraitunespractical.data.db.AppDatabase
import com.encora.encoraitunespractical.data.model.entities.MusicDataBean
import com.encora.encoraitunespractical.utils.extensions.convertToSongsBean
import javax.inject.Inject

//Repository for database and retrofit purpose
class MusicDetailsRepository @Inject constructor(
    private val appDatabase: AppDatabase,
    private val apiHelper: ApiHelper,
) {

    fun getMusicDetails() =
        performGetOperation(
            databaseQuery = { appDatabase.musicDetailsDao().getallSongs(25) },
            networkCall = { apiHelper.getItunesDetails() },
            saveCallResult = {
                appDatabase.musicDetailsDao().addAllSongs(it.entries!!.map { entry ->
                        val musicDataBean = MusicDataBean()
                        musicDataBean.apply {
                            title = entry.title
                            name = entry.name
                            price = entry.price
                            artist = entry.artist
                            duration = entry.link?.duration?.toInt()
                            imageUrl = entry.image
                            audioUrl = entry.link?.href
                            releaseDate = entry.releaseDate?.rdate
                            rights = entry.rights
                            collectionName = entry.collection?.collectionName
                        }
                    }
                    )
            })

}
