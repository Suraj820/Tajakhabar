package com.example.tajakhabar.di

import android.app.Application
import com.example.tajakhabar.data.manager.LocalUserMangerImp
import com.example.tajakhabar.domain.manager.LocalUserManager
import com.example.tajakhabar.domain.manager.useCase.AppEntryUseCases
import com.example.tajakhabar.domain.manager.useCase.ReadAppEntry
import com.example.tajakhabar.domain.manager.useCase.SaveAppEntry
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

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager: LocalUserManager)= AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )


}