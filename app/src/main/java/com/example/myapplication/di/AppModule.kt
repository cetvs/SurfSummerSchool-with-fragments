package com.example.myapplication.di

import com.example.di.DataModule
import com.example.domain.di.DomainModule
import com.example.domain.usecase.MainUseCases
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DomainModule::class, DataModule::class])
class AppModule {
    @Provides
    @Singleton
    fun provideMainViewModelFactory(useCases: MainUseCases) : MainViewModelFactory{
        return MainViewModelFactory(useCases)
    }
}