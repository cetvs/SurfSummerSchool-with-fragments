package com.example.myapplication.di

import android.app.Application
import com.example.myapplication.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}