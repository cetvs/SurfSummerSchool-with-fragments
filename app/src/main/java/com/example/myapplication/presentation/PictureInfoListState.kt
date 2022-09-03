package com.example.myapplication.presentation

import com.example.domain.model.PictureInfo

data class PictureInfoListState(
    val value : List<PictureInfo> = emptyList(),
    val error : String = "",
    val isLoading: Boolean = false
)