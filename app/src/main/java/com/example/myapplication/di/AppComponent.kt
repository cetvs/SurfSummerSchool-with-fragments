package com.example.myapplication.di

import android.app.Application
import com.example.di.DataModule
import com.example.domain.di.DomainModule
import com.example.myapplication.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
//    dependencies = [DomainComponent::class, DataComponent::class],
    modules = [AppModule::class
//        ,DomainModule::class, DataModule::class
    ]
)
interface AppComponent {
//    fun inject(surfApp: Application)

    fun inject(mainActivity: MainActivity)
}