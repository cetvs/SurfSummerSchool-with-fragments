package com.example.myapplication

import android.app.Application
//import com.example.di.DaggerDataComponent
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
//        domainComponent = DaggerDomainComponent.create()
//        appComponent = DaggerAppComponent.builder().build()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
//        dataComponent = DaggerDataComponent.create()
    }
}