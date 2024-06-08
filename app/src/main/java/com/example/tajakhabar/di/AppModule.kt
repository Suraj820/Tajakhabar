package com.example.tajakhabar.di

import android.app.Application
import com.example.tajakhabar.data.manager.LocalUserMangerImp
import com.example.tajakhabar.domain.manager.LocalUserManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager = LocalUserMangerImp(application)

}