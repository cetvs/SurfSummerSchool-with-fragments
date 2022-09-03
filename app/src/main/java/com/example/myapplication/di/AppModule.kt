package com.example.myapplication.di

import com.example.domain.usecase.MainUseCases
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideMainViewModelFactory(mainUseCases: MainUseCases) : MainViewModelFactory{
        return MainViewModelFactory(mainUseCases)
    }
}