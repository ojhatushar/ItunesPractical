package com.encora.encoraitunespractical.utils

import androidx.room.TypeConverter
import com.encora.encoraitunespractical.data.model.obj.xmlobj.Entry
import com.encora.encoraitunespractical.data.model.obj.xmlobj.ImImage
import com.encora.encoraitunespractical.data.model.obj.xmlobj.Link


import com.google.gson.Gson


class DataConverter {

    @TypeConverter
    fun listFeedToJson(value: List<Entry>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToFeed(value: String) = Gson().fromJson(value, Array<Entry>::class.java).toList()



    @TypeConverter
    fun listImImageToJson(value: List<ImImage>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToImImage(value: String) = Gson().fromJson(value, Array<ImImage>::class.java).toList()



    @TypeConverter
    fun listLinkToJson(value: List<Link>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToListLink(value: String) = Gson().fromJson(value, Array<Link>::class.java).toList()

}