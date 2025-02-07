package com.surya.daynewsapplication.domain.usecases.news

import com.surya.daynewsapplication.domain.model.Article
import com.surya.daynewsapplication.domain.repository.NewsRepository

class UpsertArticle(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(article: Article){
        newsRepository.upsertArticle(article)
    }
}