package com.example.tajakhabar.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.tajakhabar.presentation.bookmarks.BookmarkScreen
import com.example.tajakhabar.presentation.bookmarks.BookmarkViewModel
import com.example.tajakhabar.presentation.newsNavigator.NewsNavigator
import com.example.tajakhabar.presentation.onboarding.OnBoardingScreen
import com.example.tajakhabar.presentation.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    
    NavHost(navController = navController , startDestination = startDestination ){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(route = Route.OnBoardingScreen.route){
                val viewModel : OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ){
            composable( route = Route.NewsNavigatorScreen.route){
               NewsNavigator()
            }
        }
    }
    
}