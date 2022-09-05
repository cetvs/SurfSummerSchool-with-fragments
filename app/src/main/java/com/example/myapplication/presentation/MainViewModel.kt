package com.example.myapplication.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.usecase.MainUseCases
import com.example.myapplication.domain.model.EntityPictureInfo
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val mainUseCases: MainUseCases
) : ViewModel() {
    private val _state = mutableStateOf(PictureInfoListState())
    val state: State<PictureInfoListState> = _state

    private val _localState = mutableStateOf(listOf<EntityPictureInfo>())
    val localState: State<List<EntityPictureInfo>> = _localState

//    fun getPictureInfo(token: String) {
//        mainUseCases.getPictureInfo(token).onEach { result ->
//            when (result) {
//                is Resource.Success -> {
//                    _state.value = PictureInfoListState(value = result.data ?: emptyList())
//                     viewModelScope.launch(Dispatchers.IO) {
//                        mainUseCases.deleteAllMenuItems()
//                        result.data?.let {
//                            mainUseCases.insertPicturesInfo(it.map { it.toEntityPictureInfo() })
//                        }
//                    }
//                }
//                is Resource.Error ->
//                    _state.value = PictureInfoListState(error = "internet error")
//                is Resource.Loading ->
//                    _state.value = PictureInfoListState(isLoading = true)
//            }
//        }.launchIn(viewModelScope)
//    }
//
//    fun getProfileInfo(profileRequestBody: ProfileRequestBody): Resource<ProfileInfo> =
//        runBlocking {
//            mainUseCases.getProfileInfo(profileRequestBody)
//        }
//
//    fun postAuthLogout(token: String): Resource<Boolean> =
//        runBlocking {
//            mainUseCases.postAuthLogout(token)
//        }
//
//    fun getLocalPictureInfo(){
//        runBlocking(Dispatchers.IO){
//            mainUseCases.getLocalPictureInfo().onEach { _localState.value = it }
//        }
//    }
//
//    fun getLocalProfileInfo(): ProfileInfo? =
//        runBlocking(Dispatchers.IO) {
//            mainUseCases.getLocalProfileInfo()
//        }
//
//    fun insertProfileInfo(profileInfo: ProfileInfo) {
//        viewModelScope.launch(Dispatchers.IO) {
//            mainUseCases.insertProfileInfo(profileInfo)
//        }
//    }
//
//    fun deleteProfileInfo() {
//        viewModelScope.launch(Dispatchers.IO) {
//            mainUseCases.deleteProfileInfo()
//        }
//    }
}