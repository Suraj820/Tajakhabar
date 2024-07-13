package com.example.tajakhabar.presentation.bookmarks

import androidx.lifecycle.ViewModel
import com.example.tajakhabar.domain.useCase.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
):ViewModel() {
}