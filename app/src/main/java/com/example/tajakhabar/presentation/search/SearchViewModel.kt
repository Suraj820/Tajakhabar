package com.example.tajakhabar.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.tajakhabar.domain.useCase.news.NewsUseCases
import com.example.tajakhabar.domain.useCase.news.SearchNews
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val newsNewsUseCases: NewsUseCases
) :ViewModel() {

    private  val _state  = mutableStateOf(SearchState())
    val state: State<SearchState>  = _state
    fun onEvent(event: SearchEvent){
        when(event){
            is SearchEvent.UpdateSearchQuery->{
                _state.value = state.value.copy(searchQuery = event.searchQuery)
            }
            is SearchEvent.SearchNews->{
                searchNews()
            }

            else -> {}
        }
    }

    private fun searchNews() {
        val artists = newsNewsUseCases.searchNews(
            searchQuery = state.value.searchQuery,
            source = listOf("google-news-in","the-hindu","the-times-of-india","bbc-news","abc-news","al-jazeera-english")
        ).cachedIn(viewModelScope)
        _state.value = state.value.copy(articles = artists)


    }


}