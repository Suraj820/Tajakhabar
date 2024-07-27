package com.example.tajakhabar.presentation.newsNavigator

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.tajakhabar.R
import com.example.tajakhabar.domain.model.Article
import com.example.tajakhabar.presentation.bookmarks.BookmarkScreen
import com.example.tajakhabar.presentation.bookmarks.BookmarkViewModel
import com.example.tajakhabar.presentation.detail.DetailScreen
import com.example.tajakhabar.presentation.detail.DetailViewModel
import com.example.tajakhabar.presentation.detail.DetailsEvent
import com.example.tajakhabar.presentation.home.HomeScreen
import com.example.tajakhabar.presentation.home.HomeViewModel
import com.example.tajakhabar.presentation.navgraph.Route
import com.example.tajakhabar.presentation.newsNavigator.components.BottomNavigationItem
import com.example.tajakhabar.presentation.newsNavigator.components.NewsBottomNavigation
import com.example.tajakhabar.presentation.search.SearchScreen
import com.example.tajakhabar.presentation.search.SearchViewModel

@Composable
fun NewsNavigator() {
    val bottomNavigationItem = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.ic_home, text = "Home"),
            BottomNavigationItem(icon = R.drawable.ic_search_document, text = "Search"),
            BottomNavigationItem(icon = R.drawable.ic_bookmark, text = "Bookmark"),
        )
    }

    val navController = rememberNavController()
    val backstackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }
    selectedItem = remember(key1 = backstackState) {
        when(backstackState?.destination?.route){
            Route.HomeScreen.route-> 0
            Route.SearchScreen.route-> 1
            Route.BookMarkScreen.route-> 2
            else -> {0}
        }
    }

    val isBottomBarVisible = remember(key1 = backstackState) {
        backstackState?.destination?.route == Route.HomeScreen.route || backstackState?.destination?.route == Route.SearchScreen.route ||
                backstackState?.destination?.route == Route.BookMarkScreen.route
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (isBottomBarVisible){
                NewsBottomNavigation(items = bottomNavigationItem,
                    selected =  selectedItem,
                    onItemClick = { index->

                        when(index){
                            0 -> navigateToTap(
                                navController = navController,
                                route = Route.HomeScreen.route
                            )
                            1-> navigateToTap(
                                navController = navController,
                                route = Route.SearchScreen.route
                            )
                            2-> navigateToTap(
                                navController = navController,
                                route = Route.BookMarkScreen.route
                            )
                        }


                    })
            }

        }
    ){
        val bottomPadding = it.calculateBottomPadding()
        NavHost(navController = navController, startDestination = Route.HomeScreen.route, modifier =  Modifier.padding(bottom = bottomPadding)) {
            composable(route = Route.HomeScreen.route){
                val viewModel:HomeViewModel = hiltViewModel()
                val articles = viewModel.news.collectAsLazyPagingItems()
                HomeScreen(
                    articles = articles,
                    navigationToSearch = {
                        navigateToTap(navController = navController, route = Route.SearchScreen.route)
                    },
                    navigationToDetail = {article->
                        navigateToDetail(navController = navController, article = article)
                    }
                )
            }
            composable(route = Route.SearchScreen.route){
                val viewModel:SearchViewModel = hiltViewModel()
                val state = viewModel.state.value
                SearchScreen(
                   state = state,
                    event = viewModel::onEvent,
                    navigateToDetails = {article->
                        navigateToDetail(navController, article = article )
                    }

                )
            }
            composable(route = Route.DeatilScreen.route){
                val viewModel:DetailViewModel = hiltViewModel()
                if (viewModel.sideEffect != null){
                    Toast.makeText(LocalContext.current,viewModel.sideEffect,Toast.LENGTH_LONG).show()
                    viewModel.onEvent(DetailsEvent.RemoveSideEffect)
                }

                navController.previousBackStackEntry?.savedStateHandle?.get<Article?>("article")?.let {article->
                    DetailScreen(article = article , event = viewModel::onEvent, navigateUp = {
                        navController.navigateUp()
                    })
                }

            }

            composable(route = Route.BookMarkScreen.route){
                val viewModel:BookmarkViewModel = hiltViewModel()
                val state = viewModel.state.value
                BookmarkScreen(state = state, navigateToDetail = { article->
                    navigateToDetail(navController = navController,article)
                })
            }
        }
    }

}
private fun navigateToTap(navController: NavController,route: String){
    navController.navigate(route){
        navController.graph.startDestinationRoute?.let { homeScreen->
            popUpTo(homeScreen){
                saveState = true
            }
            restoreState = true
            launchSingleTop = true

        }
    }
}
private fun navigateToDetail(navController: NavController,article: Article){
    navController.currentBackStackEntry?.savedStateHandle?.set("article",article)
    navController.navigate(Route.DeatilScreen.route)
}