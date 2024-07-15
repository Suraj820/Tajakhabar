package com.example.tajakhabar.presentation.bookmarks

import com.example.tajakhabar.domain.model.Article

data class BookmarkState(
    val articles:List<Article> =  emptyList()
)
