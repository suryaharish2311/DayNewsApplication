package com.surya.daynewsapplication.domain.usecases.news

import com.surya.daynewsapplication.domain.model.Article
import com.surya.daynewsapplication.domain.repository.NewsRepository

class GetArticle(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(url: String): Article? {
        return newsRepository.selectArticle(url = url)
    }
}