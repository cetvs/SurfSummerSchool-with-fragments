package com.example.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.domain.model.EntityPictureInfo
import com.example.domain.model.ProfileInfo

@Database(entities = [EntityPictureInfo::class, ProfileInfo::class], version = 4)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuDao(): AppDao

    companion object {
        const val DATABASE_NAME = "surf_pet_database"
    }
}