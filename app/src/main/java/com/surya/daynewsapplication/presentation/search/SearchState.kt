package com.surya.daynewsapplication.presentation.search

import androidx.paging.PagingData
import com.surya.daynewsapplication.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
) {
}