package com.surya.daynewsapplication.domain.usecases.news

import com.surya.daynewsapplication.domain.model.Article
import com.surya.daynewsapplication.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.selectArticles()
    }
}