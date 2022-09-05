package com.example.myapplication.di

import android.app.Application
import com.example.di.DataModule
import com.example.domain.di.DomainModule
import com.example.domain.usecase.MainUseCases
import com.example.myapplication.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DomainModule::class, DataModule::class])
class AppModule(val app: Application) {
    @Provides
    @Singleton
    fun provideMainViewModelFactory(useCases: MainUseCases) : MainViewModelFactory{
        return MainViewModelFactory(useCases)
    }
}