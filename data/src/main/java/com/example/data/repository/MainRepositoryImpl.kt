package com.example.data.repository

import androidx.room.Update
import com.example.data.source.local.AppDao
import com.example.data.source.remote.SimpleApi
import com.example.domain.model.EntityPictureInfo
import com.example.domain.model.PictureInfo
import com.example.domain.model.ProfileInfo
import com.example.domain.repository.MainRepository
import com.example.domain.model.ProfileRequestBody
import kotlinx.coroutines.flow.Flow
import java.sql.Date

class MainRepositoryImpl(
    private val appDao: AppDao,
    private var simpleApi: SimpleApi
) : MainRepository {
    override suspend fun getProfileInfo(profileRequestBody: ProfileRequestBody): ProfileInfo? {
        return simpleApi.getProfileInfo(profileRequestBody)
    }

    override suspend fun getPictureInfo(token: String): List<PictureInfo> =
        simpleApi.getPictureInfo("Token $token")

    override suspend fun postAuthLogout(token: String) {
        simpleApi.postAuthLogout("Token $token")
    }

    override fun getLocalPictureInfo(): Flow<List<EntityPictureInfo>> =
        appDao.getPictureInfo()

    override fun getLocalProfileInfo(): ProfileInfo? =
        appDao.getProfileInfo()

    override fun insertProfileInfo(profileInfo: ProfileInfo) {
        appDao.insertProfileInfo(profileInfo)
    }

    override fun insertPicturesInfo(picturesInfo: List<EntityPictureInfo>) {
//        appDao.insertPicturesInfo(picturesInfo)
    }

    override fun checkEntityPictureInfo(id: Int) : Date? {
        return appDao.checkFavoriteDate(id)
    }

    override fun updateEntityPictureInfo(picturesInfo: EntityPictureInfo) {
        appDao.updatePictureInfo(picturesInfo)
    }

    override fun insertPictureInfo(picturesInfo: EntityPictureInfo) {
        appDao.insertPicturesInfo(picturesInfo)
    }

    override fun deleteProfileInfo(){
        appDao.deleteProfileInfo()
    }

    override fun deleteAllMenuItems() {
        appDao.deleteAllMenuItems()
    }
}