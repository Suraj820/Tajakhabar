package com.example.tajakhabar.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.tajakhabar.domain.model.Article
import com.example.tajakhabar.presentation.Dimensions

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick:()->Unit) {


    val context = LocalContext.current
    Row (modifier = Modifier.clickable { onClick() }){
        AsyncImage(
            modifier = Modifier
                .size(Dimensions.ArticleCardSize)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(context = context ).data(article.urlToImage).build() ,
            contentDescription = null  )
    }


}