package com.example.tajakhabar.presentation.detail

import com.example.tajakhabar.domain.model.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article): DetailsEvent()

    object RemoveSideEffect : DetailsEvent()
}