package com.example.myapplication.di

import android.app.Application
import androidx.room.Room
import com.example.data.repository.MainRepositoryImpl
import com.example.myapplication.data.source.local.AppDatabase
import com.example.myapplication.data.source.remote.Constants
import com.example.myapplication.data.source.remote.SimpleApi
import com.example.myapplication.domain.repository.MainRepository
import com.example.domain.usecase.*
import com.example.myapplication.SurfApp
import com.example.myapplication.domain.usecase.MainUseCases
import com.example.myapplication.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {
    @Provides
    @Singleton
    fun provideMainViewModelFactory(useCases: MainUseCases) : MainViewModelFactory{
        return MainViewModelFactory(useCases)
    }

    @Provides
    @Singleton
    fun provideDatabase(): AppDatabase {
        return Room.databaseBuilder(
            app.applicationContext,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideSimpleApi(retrofit: Retrofit): SimpleApi {
        return retrofit.create(SimpleApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepositoryDatabase(db: AppDatabase, simpleApi: SimpleApi): MainRepository {
        return MainRepositoryImpl(db.menuDao(), simpleApi)
    }

    @Provides
    @Singleton
    fun provideMenuUseCases(mainRepository: MainRepository): MainUseCases {
        return MainUseCases(
            getProfileInfo = GetProfileInfo(mainRepository),
            getPictureInfo = GetPictureInfo(mainRepository),
            postAuthLogout = PostAuthLogout(mainRepository),
            getLocalProfileInfo = GetLocalProfileInfo(mainRepository),
            getLocalPictureInfo = GetLocalPictureInfo(mainRepository),
            insertProfileInfo = InsertProfileInfo(mainRepository),
            insertPicturesInfo = InsertPicturesInfo(mainRepository),
            deleteProfileInfo = DeleteProfileInfo(mainRepository),
            deleteAllMenuItems = DeleteAllMenuItems(mainRepository),
        )
    }
}