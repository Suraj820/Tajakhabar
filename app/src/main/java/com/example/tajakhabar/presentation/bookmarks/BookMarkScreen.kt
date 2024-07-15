package com.example.tajakhabar.presentation.bookmarks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.example.tajakhabar.R
import com.example.tajakhabar.domain.model.Article
import com.example.tajakhabar.presentation.Dimensions
import com.example.tajakhabar.presentation.common.ArticlesList
import com.example.tajakhabar.presentation.navgraph.Route


@Composable
fun BookmarkScreen(
    state: BookmarkState,
    navigate:(String)-> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                top = Dimensions.MediumPadding1,
                start = Dimensions.MediumPadding1,
                end = Dimensions.MediumPadding1
            )
    ) {
        Text(
            text = "Bookmark",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.text_title)
        )
        Spacer(modifier = Modifier.height(Dimensions.MediumPadding1))
        
        ArticlesList(articles = state.articles, onArticleClick = {
            navigate(Route.DeatilScreen.route)
        } )
        
    }

}