package com.example.myapplication.presentation

import com.example.domain.model.EntityPictureInfo
import com.example.domain.model.PictureInfo

data class PictureInfoListState(
    val value : List<EntityPictureInfo> = emptyList(),
    val error : String = "",
    val isLoading: Boolean = false
)