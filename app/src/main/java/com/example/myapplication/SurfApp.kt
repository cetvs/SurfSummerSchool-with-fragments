package com.example.myapplication

import android.app.Application
import com.example.di.DataModule
import com.example.domain.di.DomainModule
import com.example.myapplication.di.AppComponent
import com.example.myapplication.di.AppModule
import com.example.myapplication.di.DaggerAppComponent

//import com.example.myapplication.di.DaggerAppComponent

class SurfApp: Application() {
    lateinit var appComponent: AppComponent
//    lateinit var dataComponent: DataComponent
//    lateinit var domainComponent: DomainComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .dataModule(DataModule(this))
            .build()
    }
}