package com.example.data.source.local

import androidx.room.*
import com.example.domain.model.EntityPictureInfo
import com.example.domain.model.ProfileInfo
import kotlinx.coroutines.flow.Flow
import java.sql.Date

@Dao
interface AppDao {
    @Insert
    fun insertProfileInfo(profileInfo: ProfileInfo)

    @Query("DELETE FROM profileInfo")
    fun deleteProfileInfo()

    @Query("SELECT * FROM profileInfo")
    fun getProfileInfo(): ProfileInfo?

    @Query("SELECT * FROM pictureInfo")
    fun getPictureInfo(): Flow<List<EntityPictureInfo>>

    @Query("Select favoriteDate FROM pictureInfo WHERE id = :id")
    fun checkFavoriteDate(id: Int): Date?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPicturesInfo(entityPictureInfo: EntityPictureInfo)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updatePictureInfo(entityPictureInfo: EntityPictureInfo)

    @Query("DELETE FROM pictureInfo")
    fun deleteAllMenuItems()

}