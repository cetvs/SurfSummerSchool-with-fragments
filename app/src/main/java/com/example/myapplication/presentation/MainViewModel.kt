package com.example.myapplication.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.*
import com.example.domain.usecase.MainUseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val mainUseCases: MainUseCases
) : ViewModel() {
    private val mutableLiveData = MutableLiveData<PictureInfoListState>()
    val liveData: LiveData<PictureInfoListState> = mutableLiveData

    fun getPictureInfo(token: String) {
        mainUseCases.getPictureInfo(token).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    val wait = viewModelScope.async(Dispatchers.IO) {
                        result.data?.let {
                            mainUseCases.insertEntityPicturesInfoToDatabase(
                                it.map { pictureInfo -> pictureInfo.toEntityPictureInfo() }
                            )
                        }
                    }
                    wait.await()
                    mainUseCases.getLocalPictureInfo().onEach {
                        mutableLiveData.postValue(PictureInfoListState(value = it))
                    }.launchIn(viewModelScope)
                }
                is Resource.Error ->
                    mutableLiveData.postValue(PictureInfoListState(error = "internet error"))
                is Resource.Loading ->
                    mutableLiveData.postValue(PictureInfoListState(isLoading = true))
            }
        }.launchIn(viewModelScope)
    }

    fun getProfileInfo(profileRequestBody: ProfileRequestBody): Resource<ProfileInfo> =
        runBlocking {
            mainUseCases.getProfileInfo(profileRequestBody)
        }

    fun postAuthLogout(token: String): Resource<Boolean> =
        runBlocking {
            mainUseCases.postAuthLogout(token)
        }

    fun getLocalPictureInfo(){
        runBlocking(Dispatchers.IO){
//            mainUseCases.getLocalPictureInfo().onEach { mutableLocalPictureInfo.postValue(it) }
        }
    }

    fun getLocalProfileInfo(): ProfileInfo? =
        runBlocking(Dispatchers.IO) {
            mainUseCases.getLocalProfileInfo()
        }

    fun insertProfileInfo(profileInfo: ProfileInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            mainUseCases.insertProfileInfo(profileInfo)
        }
    }

    fun deleteProfileInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            mainUseCases.deleteProfileInfo()
        }
    }

    fun updateFavoriteInfo(pictureInfo: EntityPictureInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            mainUseCases.updateFavoriteInfo(pictureInfo)
        }
    }
}