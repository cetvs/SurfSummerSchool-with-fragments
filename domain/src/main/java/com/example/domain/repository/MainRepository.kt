package com.example.domain.repository

import com.example.domain.model.EntityPictureInfo
import com.example.domain.model.PictureInfo
import com.example.domain.model.ProfileInfo
import com.example.domain.model.ProfileRequestBody
import kotlinx.coroutines.flow.Flow
import java.sql.Date

interface MainRepository {
    suspend fun getProfileInfo(profileRequestBody: ProfileRequestBody): ProfileInfo?
    suspend fun getPictureInfo(token: String): List<PictureInfo>
    fun getLocalPictureInfo(): Flow<List<EntityPictureInfo>>
    fun insertPicturesInfo(picturesInfo: List<EntityPictureInfo>)
    fun deleteAllMenuItems()
    fun insertProfileInfo(profileInfo: ProfileInfo)
    fun deleteProfileInfo()
    fun getLocalProfileInfo(): ProfileInfo?
    suspend fun postAuthLogout(token: String)
    fun insertPictureInfo(picturesInfo: EntityPictureInfo)
    fun checkEntityPictureInfo(id: Int): Date?
    fun updateEntityPictureInfo(picturesInfo: EntityPictureInfo)
}