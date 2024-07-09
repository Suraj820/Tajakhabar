package com.example.tajakhabar.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tajakhabar.R
import com.example.tajakhabar.presentation.Dimensions.IconSize
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text:String,
    readOnly:Boolean,
    onClick:(()->Unit)?= null,
    onValueChange:()->Unit,
    onSearch:()->Unit
) {

    val interactionSource = remember { MutableInteractionSource() }
    var isClicked = interactionSource.collectIsPressedAsState().value

    LaunchedEffect(key1 = isClicked) {
        if (isClicked){
            onClick?.invoke()
        }
    }
    
    Box(modifier = modifier){
      TextField(
          modifier = Modifier
              .fillMaxWidth()
              .searchBarBoarder(),
          value = text,
          readOnly = readOnly,
          onValueChange = {onValueChange.invoke()},
          leadingIcon ={
              Icon(
                  painter = painterResource(id = R.drawable.ic_search),
                  contentDescription = null,
                  modifier = Modifier.size(IconSize),
                  tint = colorResource(id = R.color.body)
              )
          }
      )

    }
    
}

fun Modifier.searchBarBoarder()= composed {

    if (!isSystemInDarkTheme()){
        border(
            width = 1.dp,
            color = Color.Blue,
            shape = MaterialTheme.shapes.medium
        )
    }else{
        this
    }
}