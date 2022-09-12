package com.example.domain.usecase

import com.example.domain.model.EntityPictureInfo
import com.example.domain.model.ProfileInfo
import com.example.domain.repository.MainRepository

class UpdateFavoriteInfo (
    private val repository: MainRepository
) {
    operator fun invoke(profileInfo: EntityPictureInfo) {
        repository.updateEntityPictureInfo(profileInfo)
    }
}