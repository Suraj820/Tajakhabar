package com.example.tajakhabar.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.tajakhabar.domain.model.Article
import com.example.tajakhabar.presentation.Dimensions

@Composable
fun ArticlesList(
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<Article>,
    onArticleClick: (Article) -> Unit
) {

}


@Composable
fun handlePagingResult(articles: LazyPagingItems<Article>):Boolean {

    val loadState = articles.loadState
    val error = when{
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        else -> null
    }

    return when{
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }
        error != null ->{
            EmptyScreen()
            false
        }
        else->{
            true
        }

    }

}

@Composable
fun ShimmerEffect(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(Dimensions.MediumPadding1)) {
        repeat(10) {
            ArticleCardShimmerEffect(
                modifier = Modifier.padding(horizontal = Dimensions.MediumPadding1)
            )
        }
    }
}