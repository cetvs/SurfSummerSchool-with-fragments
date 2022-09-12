package com.example.domain.usecase

class MainUseCases(
    val getProfileInfo: GetProfileInfo,
    val getPictureInfo: GetPictureInfo,
    val postAuthLogout: PostAuthLogout,
    val getLocalProfileInfo: GetLocalProfileInfo,
    val getLocalPictureInfo: GetLocalPictureInfo,
    val insertProfileInfo: InsertProfileInfo,
    val insertPicturesInfo: InsertPicturesInfo,
    val insertEntityPicturesInfoToDatabase: InsertEntityPicturesInfoToDatabase,
    val deleteProfileInfo: DeleteProfileInfo,
    val deleteAllMenuItems: DeleteAllMenuItems,
    val updateFavoriteInfo: UpdateFavoriteInfo
)