package com.encora.encoraitunespractical.data.model.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "song_data")
@Parcelize
data class MusicDataBean(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "title") var title: String? = null,
    @ColumnInfo(name = "name") var name: String? = null,
    @ColumnInfo(name = "audioUrl") var audioUrl: String? = null,
    @ColumnInfo(name = "imageUrl") var imageUrl: String? = null,
    @ColumnInfo(name = "duration") var duration: Int? = null,
    @ColumnInfo(name = "artist") var artist: String? = null,
    @ColumnInfo(name = "price") var price: String? = null,
    @ColumnInfo(name = "rights") var rights: String? = null,
    @ColumnInfo(name = "releaseDate") var releaseDate: String? = null,
    @ColumnInfo(name = "collectionName") var collectionName: String? = null
) : Parcelable