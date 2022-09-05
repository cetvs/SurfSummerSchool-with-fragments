package com.example.myapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domain.usecase.MainUseCases

class MainViewModelFactory(val mainUseCases: MainUseCases) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return MainViewModel(mainUseCases) as T
    }
}

//class MainViewModelFactory @Inject constructor(
//myViewModelProvider: Provider<MainViewModel>
//) : ViewModelProvider.Factory {
//    private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
//        MainViewModel::class.java to myViewModelProvider
//    )
//
//    override fun <T : ViewModel > create(modelClass: Class<T>): T {
//        return providers[modelClass]!!.get() as T
//    }
//}