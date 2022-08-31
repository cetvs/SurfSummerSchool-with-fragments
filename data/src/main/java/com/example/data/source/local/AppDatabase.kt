package com.example.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.model.EntityPictureInfo
import com.example.domain.model.ProfileInfo

@Database(entities = [EntityPictureInfo::class, ProfileInfo::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuDao(): AppDao

    companion object {
        const val DATABASE_NAME = "surf_pet_database"
    }
}