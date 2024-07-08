package com.example.tajakhabar.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import coil.compose.rememberImagePainter
import com.example.tajakhabar.R
import com.example.tajakhabar.domain.model.Article
import com.example.tajakhabar.presentation.Dimensions

@Composable
fun HomeScreen(articles: LazyPagingItems<Article>, navigation:(String)-> Unit) {
    val title by remember {
        derivedStateOf {
            if (articles.itemCount > 10){
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83d\uDFE5"){it.title}

            }else{
                ""
            }

        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = Dimensions.MediumPadding1)
        .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = Dimensions.MediumPadding1)
        )
        Spacer(modifier = Modifier.height(Dimensions.MediumPadding1))
        
    }


}