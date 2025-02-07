package com.surya.daynewsapplication.presentation.bookmark

import com.surya.daynewsapplication.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)