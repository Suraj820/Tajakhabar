package com.example.tajakhabar.presentation.newsNavigator.components

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tajakhabar.R
import com.example.tajakhabar.presentation.Dimensions
import com.example.tajakhabar.ui.theme.TajaKhabarTheme

@Composable
fun NewsBottomNavigation(
    items:List<BottomNavigationItem>,
    selected:Int,
    onItemClick:(Int)->Unit) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 10.dp,
    ){
        items.forEachIndexed{index, bottomNavigationItem ->  
            NavigationBarItem(
                selected = index == selected ,
                onClick = { onItemClick(index) },
                icon = {
                   Column(horizontalAlignment = CenterHorizontally) {
                       Icon(
                           painter = painterResource(id = bottomNavigationItem.icon),
                           contentDescription = null,
                           modifier = Modifier.size(Dimensions.IconSize)
                       )
                       Spacer(modifier = Modifier.height(Dimensions.ExtraSmallPadding2))
                       Text(text = bottomNavigationItem.text, style = MaterialTheme.typography.labelSmall)
                   }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = colorResource(id = R.color.body),
                    unselectedTextColor = colorResource(id = R.color.body),
                    indicatorColor = MaterialTheme.colorScheme.background,
                )
            )
        }

    }

}
data class BottomNavigationItem(
    @DrawableRes val icon: Int,
    val text:String
)

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showBackground = true)
@Composable
private fun PreviewNewsBottomNavigation() {

    TajaKhabarTheme {
        NewsBottomNavigation(items = listOf(
            BottomNavigationItem(icon = R.drawable.ic_home, text = "Home"),
            BottomNavigationItem(icon = R.drawable.ic_search_document, text = "Search"),
            BottomNavigationItem(icon = R.drawable.ic_bookmark, text = "Bookmark"),
        ), selected = 0) {

        }
    }
    
}