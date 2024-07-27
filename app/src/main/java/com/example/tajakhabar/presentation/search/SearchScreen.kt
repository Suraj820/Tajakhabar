package com.example.tajakhabar.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.tajakhabar.domain.model.Article
import com.example.tajakhabar.presentation.Dimensions
import com.example.tajakhabar.presentation.common.ArticlesList
import com.example.tajakhabar.presentation.common.SearchBar
import com.example.tajakhabar.presentation.navgraph.Route


@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    state: SearchState,
    event: (SearchEvent)->Unit,
    navigateToDetails:(Article)-> Unit
) {
    Column(
        modifier = Modifier
            .padding(
                top = Dimensions.MediumPadding1,
                start = Dimensions.MediumPadding1,
                end = Dimensions.MediumPadding1,
            )
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        SearchBar(text = state.searchQuery , readOnly =false ,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = {event(SearchEvent.SearchNews)}
        )
        Spacer(modifier = Modifier.height(Dimensions.MediumPadding1))
        state.articles?.let {
            val artists = it.collectAsLazyPagingItems()
            ArticlesList(articles = artists, onArticleClick = {navigateToDetails(it) })
        }

    }

}