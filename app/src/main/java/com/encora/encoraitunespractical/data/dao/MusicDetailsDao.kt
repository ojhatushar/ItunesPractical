package com.encora.encoraitunespractical.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.encora.encoraitunespractical.data.model.obj.xmlobj.Entry
import com.encora.encoraitunespractical.data.model.obj.xmlobj.Feed


//DAO for CRUD operations in database

@Dao
interface MusicDetailsDao {

   /* @Query("SELECT * FROM Feed")
    fun getOfflineTopSongs() : LiveData<Feed>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTopSongInfo(ResultsItem : Feed)*/

    @Query("select * from Feed")
    fun getallSongs(): LiveData<Feed>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllSongs(tipList: Feed)

    /*@Query("SELECT * from Feed where SubCategoryDetails.subCategoryID  = :id")
    fun getSubCategoryDetailsById(id: String): LiveData<List<Feed>>*/

    /*@Query("SELECT * FROM Feed")
    fun getSubCategoryDetails(): LiveData<List<Feed>>*/
}
