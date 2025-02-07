package com.surya.daynewsapplication.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.surya.daynewsapplication.data.local.NewsDao
import com.surya.daynewsapplication.data.local.NewsDatabase
import com.surya.daynewsapplication.data.local.NewsTypeConverter
import com.surya.daynewsapplication.data.manager.LocalUserManagerImpl
import com.surya.daynewsapplication.data.remote.NewsApi
import com.surya.daynewsapplication.data.repository.NewsRepositoryImpl
import com.surya.daynewsapplication.domain.manager.LocalUserManager
import com.surya.daynewsapplication.domain.repository.NewsRepository
import com.surya.daynewsapplication.domain.usecases.app_entry.AppEntryUseCases
import com.surya.daynewsapplication.domain.usecases.app_entry.ReadAppEntry
import com.surya.daynewsapplication.domain.usecases.app_entry.SaveAppEntry
import com.surya.daynewsapplication.domain.usecases.news.DeleteArticle
import com.surya.daynewsapplication.domain.usecases.news.GetArticle
import com.surya.daynewsapplication.domain.usecases.news.GetNews
import com.surya.daynewsapplication.domain.usecases.news.NewsUseCases
import com.surya.daynewsapplication.domain.usecases.news.SearchNews
import com.surya.daynewsapplication.domain.usecases.news.SelectArticles
import com.surya.daynewsapplication.domain.usecases.news.UpsertArticle
import com.surya.daynewsapplication.util.Constants
import com.surya.daynewsapplication.util.Constants.NEWS_DATABASE_NAME
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi =
        Retrofit.Builder()
            .baseUrl(Constants.NEWS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)


    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository = NewsRepositoryImpl(newsApi, newsDao)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
    ): NewsUseCases = NewsUseCases(
        getNews = GetNews(newsRepository),
        searchNews = SearchNews(newsRepository),
        deleteArticle = DeleteArticle(newsRepository),
        upsertArticle = UpsertArticle(newsRepository),
        selectArticles = SelectArticles(newsRepository),
        selectArticle = GetArticle(newsRepository)
    )

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase = Room.databaseBuilder(
        context = application,
        klass = NewsDatabase::class.java,
        name = NEWS_DATABASE_NAME
    ).addTypeConverter(NewsTypeConverter())
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao
}