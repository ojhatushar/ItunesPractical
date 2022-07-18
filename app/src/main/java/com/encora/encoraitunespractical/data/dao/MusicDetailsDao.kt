package com.encora.encoraitunespractical.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.encora.encoraitunespractical.data.model.entities.MusicDataBean


//DAO for CRUD operations in database

@Dao
interface MusicDetailsDao {

    @Query("select * from musicData LIMIT :limit")
    fun getAllSongs(limit: Int): LiveData<List<MusicDataBean>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllSongs(addMusicData: List<MusicDataBean>)

}
