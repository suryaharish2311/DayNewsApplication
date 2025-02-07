package com.surya.daynewsapplication.data.remote.dto

import com.surya.daynewsapplication.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)