package com.encora.encoraitunespractical.utils

import androidx.room.TypeConverter
import com.encora.encoraitunespractical.data.model.responseModel.Entry

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class DataConverter {

    @TypeConverter
    fun listFeedToJson(value: List<Entry>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToFeed(value: String) = Gson().fromJson(value, Array<Entry>::class.java).toList()

}