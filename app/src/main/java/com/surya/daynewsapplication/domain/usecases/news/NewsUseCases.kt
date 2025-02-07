package com.surya.daynewsapplication.domain.usecases.news

data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val deleteArticle: DeleteArticle,
    val upsertArticle: UpsertArticle,
    val selectArticles: SelectArticles,
    val selectArticle: GetArticle
)
