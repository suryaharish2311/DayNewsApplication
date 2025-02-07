package com.surya.daynewsapplication.domain.usecases.news

import com.surya.daynewsapplication.domain.model.Article
import com.surya.daynewsapplication.domain.repository.NewsRepository

class DeleteArticle(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(article: Article){
        newsRepository.deleteArticle(article)
    }
}