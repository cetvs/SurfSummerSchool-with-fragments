package com.example.domain.usecase

import com.example.domain.model.EntityPictureInfo
import com.example.domain.repository.MainRepository

class InsertEntityPicturesInfoToDatabase(
    private val repository: MainRepository,
) {
     operator fun invoke(picturesInfo: List<EntityPictureInfo>) {
        picturesInfo.forEach { pictureInfo ->
            val date = repository.checkEntityPictureInfo(pictureInfo.id)
            if (date != null) {
                repository.updateEntityPictureInfo(pictureInfo.copy(favoriteDate = date))
            } else {
                repository.insertPictureInfo(pictureInfo)
            }
        }
    }
}