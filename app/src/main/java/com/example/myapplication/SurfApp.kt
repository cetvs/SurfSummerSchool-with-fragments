package com.example.myapplication

import android.app.Application
import com.example.di.DaggerDataComponent

import com.example.di.DataComponent
import com.example.domain.di.DaggerDomainComponent
import com.example.domain.di.DomainComponent
import com.example.myapplication.di.AppComponent
import com.example.myapplication.di.DaggerAppComponent


class SurfApp: Application() {
    lateinit var appComponent: AppComponent
    lateinit var dataComponent: DataComponent
    lateinit var domainComponent: DomainComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        dataComponent = DaggerDataComponent.create()
        domainComponent = DaggerDomainComponent.create()
    }
}