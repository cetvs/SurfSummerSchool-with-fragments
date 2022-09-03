package com.example.myapplication.di

import android.app.Application
import com.example.di.DataModule
import com.example.myapplication.SurfApp
import com.example.myapplication.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
//    fun inject(surfApp: Application)

    fun inject(mainActivity: MainActivity)
}