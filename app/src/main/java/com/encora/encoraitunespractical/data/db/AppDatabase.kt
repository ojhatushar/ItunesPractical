package com.encora.encoraitunespractical.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.encora.encoraitunespractical.data.dao.MusicDetailsDao
import com.encora.encoraitunespractical.data.model.entities.MusicDataBean
import com.encora.encoraitunespractical.utils.Constants.DATABASE_NAME
import com.encora.encoraitunespractical.utils.Constants.DATABASE_VERSION
import com.encora.encoraitunespractical.utils.DataConverter


// Main Class for creating Room Database and defining versions entities etc
@Database(
    entities = [MusicDataBean::class],
    version = DATABASE_VERSION
)
@TypeConverters(DataConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun musicDetailsDao(): MusicDetailsDao


    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

}
