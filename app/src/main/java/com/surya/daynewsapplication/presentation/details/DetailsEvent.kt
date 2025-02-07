package com.surya.daynewsapplication.presentation.details

import com.surya.daynewsapplication.domain.model.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article): DetailsEvent()
    data object RemoveSideEffect: DetailsEvent()
}