package com.surya.daynewsapplication.domain.usecases.news

import androidx.paging.PagingData
import com.surya.daynewsapplication.domain.model.Article
import com.surya.daynewsapplication.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}