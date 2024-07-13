package com.example.tajakhabar.di

import android.app.Application
import androidx.room.Room
import com.example.tajakhabar.data.local.NewsDao
import com.example.tajakhabar.data.local.NewsDatabase
import com.example.tajakhabar.data.local.NewsTypeConverter
import com.example.tajakhabar.data.manager.LocalUserMangerImp
import com.example.tajakhabar.data.remote.NewsAPI
import com.example.tajakhabar.data.repository.NewsRepositoryImp
import com.example.tajakhabar.domain.manager.LocalUserManager
import com.example.tajakhabar.domain.repository.NewsRepository
import com.example.tajakhabar.domain.useCase.appEntry.AppEntryUseCases
import com.example.tajakhabar.domain.useCase.appEntry.ReadAppEntry
import com.example.tajakhabar.domain.useCase.appEntry.SaveAppEntry
import com.example.tajakhabar.domain.useCase.news.DeleteArticle
import com.example.tajakhabar.domain.useCase.news.GetNews
import com.example.tajakhabar.domain.useCase.news.InsertArticle
import com.example.tajakhabar.domain.useCase.news.NewsUseCases
import com.example.tajakhabar.domain.useCase.news.SearchNews
import com.example.tajakhabar.domain.useCase.news.SelectArticles
import com.example.tajakhabar.utils.Constant.BASE_URL
import com.example.tajakhabar.utils.Constant.DATA_BASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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


    @Provides
    @Singleton
    fun providesNewsApi():NewsAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesNewsRepository(newsAPI: NewsAPI):NewsRepository{
        return NewsRepositoryImp(newsApi = newsAPI)
    }

    @Provides
    @Singleton
    fun providesNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ):NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepository = newsRepository),
            searchNews = SearchNews(newsRepository =  newsRepository),
            insertArticle = InsertArticle(newsDao),
            deleteArticle = DeleteArticle(newsDao),
            selectArticles = SelectArticles(newsDao)
        )
    }

    @Provides
    @Singleton
    fun providesNewsDatabase(application: Application):NewsDatabase{
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = DATA_BASE_NAME
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDAO(newsDatabase: NewsDatabase):NewsDao{
        return newsDatabase.newsDao
    }


}